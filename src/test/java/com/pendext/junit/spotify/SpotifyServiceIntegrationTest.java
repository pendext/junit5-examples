package com.pendext.junit.spotify;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.pendext.junit.annotations.NetworkIntegrationTest;
import com.pendext.junit.spotify.transfer.*;
import org.junit.jupiter.api.*;

import java.io.IOException;

@NetworkIntegrationTest
public class SpotifyServiceIntegrationTest {

    private static SpotifyService spotifyService;
    private static final String ARTIST_ID = "5CWbfANRpZbnxdstzcNg5H";

    @BeforeAll
    public static void beforeAll() {
        spotifyService = new SpotifyService();
    }

    @Test
    @DisplayName("Rest client can retrieve information from Spotify.")
    public void spotifyServiceCanRetrieveInformationFromSpotify() throws IOException {
        ArtistInfo artistInfo = spotifyService.getArtistInfo(ARTIST_ID);
        assertEquals(artistInfo.getName(), "Bill Monroe");
        assertEquals(artistInfo.getType(), "artist");
    }

    @Test
    public void spotifyServiceCanReturnTopTracksList() throws IOException {
        TopTracksList topTracksList = spotifyService.getTopTracksList(ARTIST_ID);
        assertNotNull(topTracksList);
        assertEquals(10, topTracksList.getTracks().size());
    }


}