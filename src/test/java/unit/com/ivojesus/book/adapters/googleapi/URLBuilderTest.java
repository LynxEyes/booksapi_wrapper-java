package unit.com.ivojesus.book.adapters.googleapi;

import com.ivojesus.book.adapters.googleapi.URLBuilder;
import com.ivojesus.book.core.BookQuery;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class URLBuilderTest {
    private String baseURL = "http://localhost:9876/books?q=";

    private URLBuilder subject = new URLBuilder(baseURL);

    @Test
    public void whenQueryHasNoTermThenBuildOnlyReturnsTheBaseUrl() {
        String result = subject.build(new BookQuery());

        assertThat(result, is(equalTo(baseURL)));
    }

    @Test
    public void whenQueryHasTermThenBuildReturnsTheBaseUrlAndTerm() {
        String term = "tolkien";

        String result = subject.build(new BookQuery(term));

        assertThat(result, is(startsWith(baseURL)));
        assertThat(result, is(endsWith(term)));
    }
}
