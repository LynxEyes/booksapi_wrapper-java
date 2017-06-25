package com.ivojesus.book.adapters.googleapi;

import com.ivojesus.book.core.BookQuery;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Optional;

public class URLBuilder {
    private final String baseURL;

    @Inject
    public URLBuilder(@Named("baseURL") String baseURL) {
        this.baseURL = baseURL;
    }

    public String build(BookQuery query) {
        String result = baseURL;

        Optional<String> term = Optional.ofNullable(query.getTerm());

        if (term.isPresent()) {
            result = result + term.get();
        }

        return result;
    }
}
