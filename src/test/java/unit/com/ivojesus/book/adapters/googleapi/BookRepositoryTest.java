package unit.com.ivojesus.book.adapters.googleapi;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import com.ivojesus.book.adapters.googleapi.BookRepository;
import com.ivojesus.book.adapters.googleapi.URLBuilder;
import com.ivojesus.book.core.Book;
import com.ivojesus.book.core.BookQuery;
import com.ivojesus.book.adapters.googleapi.HTTPClient;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static com.google.common.io.Resources.getResource;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BookRepositoryTest {
    private URLBuilder mockBuilder = mock(URLBuilder.class);
    private HTTPClient mockClient = mock(HTTPClient.class);

    private BookRepository subject = new BookRepository(mockClient, mockBuilder);

    @Test
    public void fetchesDataOnTheAPIAndProducesABookList() throws IOException {
        BookQuery someQuery = new BookQuery();
        String url = "http://localhost:9876/books?q=tolkien";
        String text = Resources.toString(getResource("tolkien.json"), Charsets.UTF_8);

        when(mockBuilder.build(someQuery)).thenReturn(url);
        when(mockClient.get(url)).thenReturn(text);

        List<Book> result = subject.search(someQuery);

        assertThat(result.get(0).getTitle(), is(equalTo("J.R.R. Tolkien")));
        assertThat(result.get(1).getTitle(), is(equalTo("J.R.R. Tolkien")));
        assertThat(result.get(2).getTitle(), is(equalTo("J.R.R. Tolkien Encyclopedia")));
        assertThat(result.get(3).getTitle(), is(equalTo("O Silmarillion")));
    }
}
