package com.ivojesus.adapters.cli;

import com.beust.jcommander.Parameter;
import com.ivojesus.core.books.BookQuery;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class BookCLIArgs {
    @Parameter @Getter private String term;

    public BookQuery toRequestModel(){
        return new BookQuery(term);
    }
}
