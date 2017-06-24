package acceptance;

import com.ivojesus.adapters.cli.BookCLI;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Pattern;
import java.util.regex.*;

import static com.ivojesus.app.Application.context;
import static java.util.regex.Pattern.CASE_INSENSITIVE;
import static java.util.regex.Pattern.MULTILINE;
import static java.util.regex.Pattern.compile;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.matchesPattern;

public class BooksCLITest {

    private ByteArrayOutputStream baos;
    private final PrintStream originalOut = System.out;
    private final BookCLI cli = context().getInstance(BookCLI.class);

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

    @Test
    public void WhenGivenATermPrintsBooksThatMatchTheTerm() {
        String term = "tolkien";
        String[] args = new String[]{term};

        // TODO: What I need here is to stub the API call and assert on the expected output.
//        Pattern pattern = compile(".*Tolkien.*", CASE_INSENSITIVE);
//
//        cli.run(args);
//
//        assertThat(baos.toString(), matchesPattern(pattern));
    }
}
