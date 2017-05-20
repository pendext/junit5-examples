package com.pendext.junit.spotify;

import com.pendext.junit.rest.RestClient;
import com.pendext.junit.spotify.transfer.*;

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

    public TopTracksList getTopTracksList(String artistId) throws IOException {
        return new TopTracksList(restClient.get(getTopTracksUrl(artistId)));
    }

    private String getTopTracksUrl(String artistId) {
        return SPOTIFY_GET_ARTIST_URL + artistId + "/top-tracks?country=US";
    }

}
