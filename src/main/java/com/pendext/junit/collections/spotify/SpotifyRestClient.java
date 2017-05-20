package com.pendext.junit.collections.spotify;

import okhttp3.*;
import org.apache.commons.io.IOUtils;

import java.io.IOException;

public class SpotifyRestClient {

    private final OkHttpClient client = new OkHttpClient();
    private static final String SPOTIFY_GET_URL = "https://api.spotify.com/v1/artists/";

    public ArtistInfo getArtistInfo(String artistId) throws IOException {
        Request request = new Request.Builder()
                .url(SPOTIFY_GET_URL + artistId)
                .build();

        Response response = client.newCall(request).execute();
        String responseJson = IOUtils.toString(response.body().bytes(), "UTF-8");
        return new ArtistInfo().fromJSON(responseJson);
    }
    
}
