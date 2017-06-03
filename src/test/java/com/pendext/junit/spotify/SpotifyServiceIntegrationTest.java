package com.pendext.junit.spotify;

import static org.junit.jupiter.api.Assertions.*;

import com.pendext.junit.annotations.NetworkIntegrationTest;
import com.pendext.junit.spotify.transfer.*;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.util.List;

@NetworkIntegrationTest
public class SpotifyServiceIntegrationTest {

    private static SpotifyService spotifyService;
    private static final String BILL_MONROE_ARTIST_ID = "5CWbfANRpZbnxdstzcNg5H";

    @BeforeAll
    public static void beforeAll(TestInfo testInfo) {
        spotifyService = new SpotifyService();
    }

    @BeforeEach
    public void beforeEach(TestInfo testInfo) {
        testInfo.getDisplayName();
    }

    @Test
    @DisplayName("Spotify service can retrieve information from Spotify.")
    public void spotifyServiceCanRetrieveInformationFromSpotify() throws IOException {
        ArtistInfo artistInfo = spotifyService.getArtistInfo(BILL_MONROE_ARTIST_ID);
        assertEquals(artistInfo.getName(), "Bill Monroe");
        assertEquals(artistInfo.getType(), "artist");
    }

    @Test
    @DisplayName("Spotify service returns valid top tracks list.")
    public void spotifyServiceCanReturnTopTracksList() throws IOException {
        TopTracksList topTracksList = spotifyService.getTopTracksList(BILL_MONROE_ARTIST_ID);
        assertNotNull(topTracksList, "The object was not and should not have been.");
        assertEquals(10, topTracksList.getTracks().size(), "The number of actual top tracks did not match the expected.");
    }

    @Test
    @DisplayName("Spotify service returns expected top tracks - using multiple asserts")
    public void spotifyServiceReturnsExpectedTopTracksMultipleAsserts() throws IOException {
        TopTracksList topTracksList = spotifyService.getTopTracksList(BILL_MONROE_ARTIST_ID);
        List<Track> tracks = topTracksList.getTracks();

        assertEquals("Uncle Pen", tracks.get(0).getName(), "The track name was not what was expected.");
        assertEquals("Southern Flavor", tracks.get(1).getName(), "The track name was not what was expected.");
        assertEquals("Man of Constant Sorrow", tracks.get(2).getName(), "The track name was not what was expected.");
        assertEquals("Pancho and Lefty", tracks.get(3).getName(), "The track name was not what was expected.");
    }

    @Test
    @DisplayName("Spotify service returns expected top tracks - using assertAll")
    public void spotifyServiceReturnsExpectedTopTracks() throws IOException {
        TopTracksList topTracksList = spotifyService.getTopTracksList(BILL_MONROE_ARTIST_ID);
        List<Track> tracks = topTracksList.getTracks();

        assertAll("Top tracks returned from Spotify are exactly the tracks expected.",
                () -> assertEquals("Uncle Pen", tracks.get(0).getName(), "The track name was not what was expected."),
                () -> assertEquals("Southern Flavor", tracks.get(1).getName(), "The track name was not what was expected."),
                () -> assertEquals("Man of Constant Sorrow", tracks.get(2).getName(), "The track name was not what was expected."),
                () -> assertEquals("Pancho and Lefty", tracks.get(3).getName(), "The track name was not what was expected."));
    }



}