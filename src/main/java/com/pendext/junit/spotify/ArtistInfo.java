package com.pendext.junit.spotify;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ArtistInfo {
    private String name;
    private int popularity;
    private String type;
    private String href;
    private List<String> genres;

    public ArtistInfo() {}

    public ArtistInfo(String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ArtistInfo artistInfo = mapper.readValue(json, ArtistInfo.class);
        this.setGenres(artistInfo.getGenres());
        this.setHref(artistInfo.getHref());
        this.setName(artistInfo.getName());
        this.setType(artistInfo.getType());
        this.setPopularity(artistInfo.getPopularity());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

}

