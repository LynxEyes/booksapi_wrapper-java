package com.ivojesus.adapters.googleapi;

import java.io.IOException;

public interface HTTPClient {
    String get(String url) throws IOException;
}
