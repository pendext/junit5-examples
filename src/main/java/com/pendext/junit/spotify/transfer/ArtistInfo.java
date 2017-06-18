package com.pendext.junit.spotify.transfer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang3.builder.EqualsBuilder;

import java.io.IOException;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ArtistInfo extends BaseSpotifyObject {
    private List<String> genres;

    public ArtistInfo() {}

    public ArtistInfo(String json) throws IOException {
        super(json, ArtistInfo.class);
        ArtistInfo artistInfo = mapper.readValue(json, ArtistInfo.class);
        this.setGenres(artistInfo.getGenres());
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    @Override
    public boolean equals(Object otherArtistInfo) {
        ArtistInfo other = (ArtistInfo) otherArtistInfo;
        if (otherArtistInfo == null) {
            return false;
        }
        return new EqualsBuilder()
                .append(this.getHref(), other.getHref())
                .append(this.getName(), other.getName())
                .append(this.getPopularity(), other.getPopularity())
                .isEquals();
    }

}

