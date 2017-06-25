package com.ivojesus.book.adapters.googleapi;

import java.io.IOException;

public interface HTTPClient {
    String get(String url) throws IOException;
}
