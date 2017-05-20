package com.pendext.junit.spotify;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.pendext.junit.annotations.NetworkIntegrationTest;
import org.junit.jupiter.api.*;

import java.io.IOException;

@NetworkIntegrationTest
public class SpotifyServiceIntegrationTest {

    private static SpotifyService spotifyService;

    @BeforeAll
    public static void beforeAll() {
        spotifyService = new SpotifyService();
    }

    @Test
    @DisplayName("Rest client can retrieve information from Spotify.")
    public void spotifyServiceCanRetrieveInformationFromSpotify() throws IOException {
        ArtistInfo artistInfo = spotifyService.getArtistInfo("5CWbfANRpZbnxdstzcNg5H");
        assertEquals(artistInfo.getName(), "Bill Monroe");
        assertEquals(artistInfo.getType(), "artist");
    }

}