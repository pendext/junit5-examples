package com.pendext.junit.spotify;

import static org.junit.jupiter.api.Assertions.*;

import com.pendext.junit.annotations.NetworkIntegrationTest;
import com.pendext.junit.spotify.transfer.*;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.util.List;

@NetworkIntegrationTest
@DisplayName("Spotify service nested integration tests")
class SpotifyServiceNestedIntegrationTest {

    private static SpotifyService spotifyService;
    private final String ARTIST_ID = "5CWbfANRpZbnxdstzcNg5H";

    @BeforeEach
    public void beforeAll() {
        spotifyService = new SpotifyService();
    }

    @Nested
    @DisplayName("Basic service validations")
    class BasicTest {
        @Test
        @DisplayName("Spotify service should not be null after instantiation.")
        public void spotifyServiceCanBeInstantiated() {
            assertTrue(spotifyService != null);
        }
    }

    @Nested
    @DisplayName("Tests to validate the artist information Spotify call")
    class ArtistInfoTests {
        @Test
        @DisplayName("Spotify service can retrieve information from Spotify.")
        public void spotifyServiceCanRetrieveInformationFromSpotify() throws IOException {
            ArtistInfo artistInfo = spotifyService.getArtistInfo(ARTIST_ID);
            assertEquals(artistInfo.getName(), "David Grisman");
            assertEquals(artistInfo.getType(), "artist");
        }

        @Test
        @DisplayName("Spotify service returns valid top tracks list.")
        public void spotifyServiceCanReturnTopTracksList() throws IOException {
            TopTracksList topTracksList = spotifyService.getTopTracksList(ARTIST_ID);
            assertNotNull(topTracksList, "The object was not and should not have been.");
            assertEquals(10, topTracksList.getTracks().size(), "The number of actual top tracks did not match the expected.");
        }
    }

    @Nested
    @DisplayName("Tests to validate the top tracks Spotify call")
    class TopTracksTests {

        @Test
        @DisplayName("Spotify service returns expected top tracks - using multiple asserts")
        public void spotifyServiceReturnsExpectedTopTracksMultipleAsserts() throws IOException {
            TopTracksList topTracksList = spotifyService.getTopTracksList(ARTIST_ID);
            List<Track> tracks = topTracksList.getTracks();

            assertEquals("Pancho and Lefty", tracks.get(3).getName(), "The track name was not what was expected.");
            assertEquals("Uncle Pen", tracks.get(0).getName(), "The track name was not what was expected.");
            assertEquals("Southern Flavor", tracks.get(1).getName(), "The track name was not what was expected.");
            assertEquals("Man of Constant Sorrow", tracks.get(2).getName(), "The track name was not what was expected.");
        }

        @Test
        @DisplayName("Spotify service returns expected top tracks - using assertAll")
        public void spotifyServiceReturnsExpectedTopTracks() throws IOException {
            TopTracksList topTracksList = spotifyService.getTopTracksList(ARTIST_ID);
            List<Track> tracks = topTracksList.getTracks();

            assertAll("Top tracks returned from Spotify are exactly the tracks expected.",
                    () -> assertEquals("Uncle Pen", tracks.get(0).getName(), "The track name was not what was expected."),
                    () -> assertEquals("Southern Flavor", tracks.get(1).getName(), "The track name was not what was expected."),
                    () -> assertEquals("Man of Constant Sorrow", tracks.get(2).getName(), "The track name was not what was expected."),
                    () -> assertEquals("Pancho and Lefty", tracks.get(3).getName(), "The track name was not what was expected."));
        }
    }

}