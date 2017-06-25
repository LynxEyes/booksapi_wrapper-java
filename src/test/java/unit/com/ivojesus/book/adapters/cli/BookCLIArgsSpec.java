package unit.com.ivojesus.book.adapters.cli;

import com.greghaskins.spectrum.Spectrum;
import com.ivojesus.book.adapters.cli.BookCLIArgs;
import com.ivojesus.book.core.BookQuery;
import org.junit.runner.RunWith;

import static com.greghaskins.spectrum.Spectrum.it;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

@RunWith(Spectrum.class)
public class BookCLIArgsSpec {{
    it("has a getter for the term property", () -> {
        String term = "someRandomTerm";
        BookCLIArgs args = new BookCLIArgs(term);

        assertThat(args.getTerm(), is(equalTo(term)));
    });

    it("provides a conversion to FindBooksRequestModel", () -> {
        String term = "someRandomTerm";
        BookCLIArgs args = new BookCLIArgs(term);
        BookQuery requestModel = new BookQuery(term);

        assertThat(args.toRequestModel(), is(equalTo(requestModel)));
    });
}}
