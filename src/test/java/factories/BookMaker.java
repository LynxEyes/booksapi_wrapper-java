package factories;

import com.ivojesus.book.core.Book;
import com.natpryce.makeiteasy.Instantiator;
import com.natpryce.makeiteasy.Property;
import com.natpryce.makeiteasy.PropertyLookup;

import static com.natpryce.makeiteasy.Property.newProperty;

public class BookMaker {
    public static final Property<Book,String> title = newProperty();

    public static final String DEFAULT_TITLE = "Some Random Title";

    public static final Instantiator<Book> book = new Instantiator<Book>() {
        @Override public Book instantiate(PropertyLookup<Book> lookup) {
            Book book = new Book(lookup.valueOf(title, DEFAULT_TITLE));
            return book;
        }
    };
}
