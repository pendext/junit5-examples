package com.pendext.junit.spotify;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

@Tag("integration")
@Tag("requires network")
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