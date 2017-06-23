package com.ivojesus.adapters.cli;

import com.beust.jcommander.JCommander;
import com.ivojesus.core.books.Book;
import com.ivojesus.core.books.IFindBooks;

import javax.inject.Inject;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.empty;
import static java.util.Optional.of;

public class BookCLI {
    private final IFindBooks findBooks;

    @Inject
    public BookCLI(IFindBooks findBooks) {
        this.findBooks = findBooks;
    }

    public void run(String[] argv) {
        Optional<BookCLIArgs> args = parseArguments(argv);

        args.ifPresent(
                bookArgs -> {
                    try {
                        printBooks(findBooks.search(bookArgs.toRequestModel()));
                    } catch (IOException e) {
                        System.out.println("Sorry, there seems to be some network problem.");
                    }
                }
        );
    }

    private void printBooks(List<Book> books) {
        books.forEach( book -> System.out.println(book.getTitle()) );
    }

    private Optional<BookCLIArgs> parseArguments(String[] argv) {
        BookCLIArgs args = new BookCLIArgs();

        JCommander commander = JCommander.newBuilder()
                .addObject(args)
                .build();

        if (argv.length == 0) {
            commander.usage();
            return empty();
        } else {
            commander.parse(argv);
            return of(args);
        }
    }
}
