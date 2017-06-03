package com.pendext.junit.rest;

import okhttp3.*;
import org.apache.commons.io.IOUtils;

import java.io.IOException;

public class RestClient {

    private final OkHttpClient client = new OkHttpClient();

    public String get(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .addHeader("Authorization", "Bearer ")
                .build();

        Response response = client.newCall(request).execute();
        return IOUtils.toString(response.body().bytes(), "UTF-8");
    }

}
