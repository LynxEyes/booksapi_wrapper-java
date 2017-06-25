package com.ivojesus.book.adapters.googleapi;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ivojesus.book.adapters.googleapi.entities.ApiResponse;
import com.ivojesus.book.core.Book;
import com.ivojesus.book.core.IBookRepository;
import com.ivojesus.book.core.BookQuery;

import javax.inject.Inject;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BookRepository implements IBookRepository {
    private final HTTPClient httpClient;
    private final URLBuilder builder;
    private final ObjectMapper mapper;

    @Inject
    public BookRepository(HTTPClient httpClient, URLBuilder builder) {
        this.httpClient = httpClient;
        this.builder = builder;
        this.mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @Override
    public List<Book> search(BookQuery query) throws IOException {
        String books = httpClient.get(builder.build(query));
        ApiResponse resp = mapper.readValue(books, ApiResponse.class);

        return Arrays.stream(resp.items)
                .map(volume -> new Book(volume.volumeInfo.title))
                .collect(Collectors.toList());
    }
}
