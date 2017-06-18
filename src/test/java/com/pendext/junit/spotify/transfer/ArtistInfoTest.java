package com.pendext.junit.spotify.transfer;

import com.pendext.junit.util.EqualsTestable;

import java.io.IOException;

class ArtistInfoTest implements EqualsTestable<ArtistInfo> {

    private String billMonroeJson = "{ ... }";

    private String otherArtistJson = "{ ... }";

    @Override
    public ArtistInfo createObject() throws IOException {
        return new ArtistInfo(billMonroeJson);
    }

    @Override
    public ArtistInfo createUnequalObject() throws IOException {
        return new ArtistInfo(otherArtistJson);
    }

}