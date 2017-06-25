package com.ivojesus.app;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.name.Names;
import com.ivojesus.book.adapters.googleapi.BookRepository;
import com.ivojesus.book.adapters.googleapi.HTTPClient;
import com.ivojesus.book.adapters.googleapi.OkHTTPClient;
import com.ivojesus.book.adapters.cli.BookCLI;
import com.ivojesus.book.core.IBookRepository;
import com.ivojesus.book.core.FindBooks;
import com.ivojesus.book.core.IFindBooks;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Application {

    public static void main(String[] args) {
        context().getInstance(BookCLI.class).run(args);
    }

    public static Injector context() {
        return Guice.createInjector(new AppContext());
    }

    private static class AppContext extends AbstractModule {
        private Properties properties;

        public AppContext() {
            this.properties = setupEnv();
        }

        @Override
        protected void configure() {
            bind(IFindBooks.class).to(FindBooks.class);
            bind(IBookRepository.class).to(BookRepository.class);
            bind(String.class).annotatedWith(Names.named("baseURL")).toInstance(properties.getProperty("BASE_URL"));
            bind(HTTPClient.class).to(OkHTTPClient.class);
        }

        private Properties setupEnv() {
            Properties props = new Properties();
            InputStream is = Application.class.getResourceAsStream("/env.properties");

            try {
                if (is != null)
                    props.load(is);
            } catch (IOException e) {
                // TODO: Do something... like complain or something
            }

            return props;
        }
    }
}
