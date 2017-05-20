package com.pendext.junit.spotify.transfer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseSpotifyObject {

    private String name;
    private int popularity;
    private String type;
    private String href;

    protected ObjectMapper mapper = new ObjectMapper();

    public BaseSpotifyObject() {}

    public BaseSpotifyObject(String json, Class clazz) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        BaseSpotifyObject mappedObject = (BaseSpotifyObject) mapper.readValue(json, clazz);
        this.setHref(mappedObject.getHref());
        this.setName(mappedObject.getName());
        this.setType(mappedObject.getType());
        this.setPopularity(mappedObject.getPopularity());
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
}
