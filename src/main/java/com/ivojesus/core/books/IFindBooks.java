package com.ivojesus.core.books;

import java.io.IOException;
import java.util.List;

public interface IFindBooks {
    List<Book> search(BookQuery query) throws IOException;
}
