package com.pendext.junit.spotify;

import static org.junit.jupiter.api.Assertions.*;

import com.pendext.junit.annotations.NetworkIntegrationTest;
import com.pendext.junit.spotify.transfer.*;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.util.List;

@NetworkIntegrationTest
@DisplayName("SpotifyService test")
class BehaviorDrivenSpotifyServiceNestedIntegrationTest {

    private static SpotifyService spotifyService;
    private final String ARTIST_ID = "5CWbfANRpZbnxdstzcNg5H";

    @BeforeEach
    public void beforeAll() {
        spotifyService = new SpotifyService();
    }

    @Nested
    @DisplayName("Basic lights on tests")
    class BasicTests {
        @Nested
        @DisplayName("Given I am a SpotifyService")
        class Given {
            @Nested
            @DisplayName("When I am instantiated")
            class When {
                @Nested
                @DisplayName("Then I should not be null")
                class Then {
                    @Test
                    @DisplayName("Spotify service should not be null after instantiation.")
                    public void spotifyServiceCanBeInstantiated() {
                        assertTrue(spotifyService == null);
                    }
                }
            }
        }
    }


    @Nested
    @DisplayName("getTopTracks()")
    class ArtistInfoTests {
        @Nested
        @DisplayName("Given I am a SpotifyService")
        class Given {
            @Nested
            @DisplayName("When I invoke the getTopTracks() call")
            class When {
                @Nested
                @DisplayName("Then I should be able to retrieve correct number of top tracks")
                class ThenTopTracksOne {
                    @Test
                    @DisplayName("getTopTracks() returns correct number of tracks")
                    public void spotifyServiceCanReturnTopTracksList() throws IOException {
                        TopTracksList topTracksList = spotifyService.getTopTracksList(ARTIST_ID);
                        assertNotNull(topTracksList, "The object was not and should not have been.");
                        assertEquals(9, topTracksList.getTracks().size(), "The number of actual top tracks did not match the expected.");
                    }
                }
                @Nested
                @DisplayName("Then the top track information being returned should be correct")
                class ThenTopTracksTwo {
                    @Test
                    @DisplayName("getTopTracks() returns correct track information for artist")
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
        }


    }
}