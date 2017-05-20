package com.pendext.junit.spotify.transfer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.IOException;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Track extends BaseSpotifyObject {
    private int trackNumber;

    public Track() {}

    public Track(String json) throws IOException {
        super(json, Track.class);
        Track track = mapper.readValue(json, Track.class);
        this.setTrackNumber(track.getTrackNumber());
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(int trackNumber) {
        this.trackNumber = trackNumber;
    }

}
