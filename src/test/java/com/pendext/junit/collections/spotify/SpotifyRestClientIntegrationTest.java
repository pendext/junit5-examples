package com.pendext.junit.collections.spotify;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

@Tag("integration")
public class SpotifyRestClientIntegrationTest {

    private static SpotifyRestClient spotifyRestClient;

    @BeforeAll
    public static void beforeAll() {
        spotifyRestClient = new SpotifyRestClient();
    }

    @Test
    @DisplayName("Rest client can retrieve information from Spotify.")
    public void restClientCanRetrieveInformationFromSpotify() throws IOException {
        ArtistInfo artistInfo = spotifyRestClient.getArtistInfo("5CWbfANRpZbnxdstzcNg5H");
        assertEquals(artistInfo.getName(), "Bill Monroe");
    }
}