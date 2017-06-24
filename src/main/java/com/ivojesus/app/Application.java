package com.ivojesus.app;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.name.Names;
import com.ivojesus.adapters.googleapi.BookRepository;
import com.ivojesus.adapters.googleapi.HTTPClient;
import com.ivojesus.adapters.googleapi.OkHTTPClient;
import com.ivojesus.adapters.cli.BookCLI;
import com.ivojesus.core.books.IBookRepository;
import com.ivojesus.core.books.FindBooks;
import com.ivojesus.core.books.IFindBooks;

public class Application {

    public static void main(String[] args) {
        context().getInstance(BookCLI.class).run(args);
    }

    public static Injector context() {
        return Guice.createInjector(new AppContext());
    }

    private static class AppContext extends AbstractModule {
        @Override
        protected void configure() {
            bind(IFindBooks.class).to(FindBooks.class);
            bind(IBookRepository.class).to(BookRepository.class);
            bind(String.class).annotatedWith(Names.named("baseURL")).toInstance("https://www.googleapis.com/books/v1/volumes?q=");
            bind(HTTPClient.class).to(OkHTTPClient.class);
        }
    }
}
