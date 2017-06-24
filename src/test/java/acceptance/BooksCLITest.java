package acceptance;

import com.ivojesus.adapters.cli.BookCLI;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import support.StubbedNetworkTest;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Pattern;

import static com.ivojesus.app.Application.context;
import static java.util.regex.Pattern.CASE_INSENSITIVE;
import static java.util.regex.Pattern.compile;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.matchesPattern;
import static org.hamcrest.core.StringContains.containsStringIgnoringCase;

public class BooksCLITest extends StubbedNetworkTest {

    private ByteArrayOutputStream baos;
    private final PrintStream originalOut = System.out;
    private final BookCLI cli = context().getInstance(BookCLI.class);

    @Override
    public String getStubbyFile() {
        return "src/test/resources/stubby.yml";
    }

    @Before
    public void setUp() {
        baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
    }

    @After
    public void tearDown() {
        System.out.flush();
        System.setOut(originalOut);
    }

    @Test
    public void WhenRunningWithoutArgumentsPrintsUsageMessage() {
        String[] args = new String[]{};
        cli.run(args);
        assertThat(baos.toString(), startsWith("Usage: "));
    }

    // TODO: This is far from a meaningful test... I need to find a way to better assert that the response makes sense.
    @Test
    public void WhenGivenATermPrintsBooksThatMatchTheTerm() {
        String term = "tolkien";
        String[] args = new String[]{term};

        cli.run(args);

        assertThat(baos.toString(), containsStringIgnoringCase(term));
    }
}
