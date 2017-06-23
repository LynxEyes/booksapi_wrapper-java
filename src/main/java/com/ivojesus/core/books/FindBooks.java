package com.ivojesus.core.books;

import javax.inject.Inject;
import java.io.IOException;
import java.util.List;

public class FindBooks implements IFindBooks {
    private final IBookRepository bookRepository;

    @Inject
    public FindBooks(IBookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> search(BookQuery query) throws IOException {
        return bookRepository.search(query);
    }
}
