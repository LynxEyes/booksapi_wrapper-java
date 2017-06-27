package unit.com.ivojesus.book.core;

import com.ivojesus.book.core.Book;
import com.ivojesus.book.core.BookQuery;
import com.ivojesus.book.core.FindBooks;
import com.ivojesus.book.core.IBookRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static com.natpryce.makeiteasy.MakeItEasy.a;
import static com.natpryce.makeiteasy.MakeItEasy.make;
import static com.natpryce.makeiteasy.MakeItEasy.with;
import static factories.BookMaker.book;
import static factories.BookMaker.title;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

public class FindBooksTest {
    @Mock private IBookRepository bookRepository;
    @Mock private BookQuery query;
    @InjectMocks private FindBooks subject;

    private final Book book0 = make(a(book, with(title, "One title")));
    private final Book book1 = make(a(book, with(title, "Another title")));
    private final List<Book> books = Arrays.asList(book0, book1);

    @Before public void initMocks() {
         MockitoAnnotations.initMocks(this);
    }

    @Test public void searchIsRelayedToTheBookRepository() throws IOException {
        given(bookRepository.search(any(BookQuery.class))).willReturn(books);
        subject.search(query);
        verify(bookRepository).search(query);
    }

    @Test public void booksReturnedAreThoseReturnedByTheRepository() throws IOException {
        given(bookRepository.search(any(BookQuery.class))).willReturn(books);

        // when I perform a search
        List<Book> result = subject.search(query);

        // then I get back the books returned by the book repository
        bookMatches(result.get(0), book0);
        bookMatches(result.get(1), book1);
    }

    private void bookMatches(Book left, Book right) {
        assertThat(left.getTitle(), is(equalTo(right.getTitle())));
    }
}
