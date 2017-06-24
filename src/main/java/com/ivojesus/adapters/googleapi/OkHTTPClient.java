package com.ivojesus.adapters.googleapi;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import javax.inject.Inject;
import java.io.IOException;

public class OkHTTPClient implements HTTPClient {
    private final OkHttpClient client;

    @Inject
    public OkHTTPClient() {
        this.client = new OkHttpClient();
    }

    @Override
    public String get(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }
}
