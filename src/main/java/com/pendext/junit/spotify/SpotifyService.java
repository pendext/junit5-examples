package com.pendext.junit.spotify;

import com.pendext.junit.rest.RestClient;

import java.io.IOException;

public class SpotifyService {

    private RestClient restClient;
    private static final String SPOTIFY_GET_ARTIST_URL = "https://api.spotify.com/v1/artists/";

    public SpotifyService() {
        restClient = new RestClient();
    }

    public ArtistInfo getArtistInfo(String artistId) throws IOException {
        return new ArtistInfo((restClient.get(SPOTIFY_GET_ARTIST_URL + artistId)));
    }

}
