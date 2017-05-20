package com.pendext.junit.spotify.transfer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TopTracksList {
    private List<Track> tracks;

    public TopTracksList() {}

    public TopTracksList(String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        TopTracksList topTracksList = mapper.readValue(json, TopTracksList.class);
        tracks = new ArrayList<>();
        tracks.addAll(topTracksList.getTracks());
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }

}
