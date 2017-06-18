package com.pendext.junit.spotify.transfer;

import com.pendext.junit.util.EqualsTestable;

import java.io.IOException;

class ArtistInfoTest implements EqualsTestable<ArtistInfo> {

    private String billMonroeJson = "{\n" +
                                "\t\"genres\": [\"appalachian folk\", \"bluegrass\", \"country christmas\", \"country gospel\", \"cowboy western\", \"folk christmas\", \"nashville sound\", \"old-time\", \"progressive bluegrass\", \"traditional country\", \"traditional folk\"],\n" +
                                "\t\"href\": \"https://api.spotify.com/v1/artists/5CWbfANRpZbnxdstzcNg5H\",\n" +
                                "\t\"id\": \"5CWbfANRpZbnxdstzcNg5H\",\n" +
                                "\t\"name\": \"Bill Monroe\",\n" +
                                "\t\"popularity\": 35,\n" +
                                "\t\"type\": \"artist\",\n" +
                                "\t\"uri\": \"spotify:artist:5CWbfANRpZbnxdstzcNg5H\"\n" +
                                "}";

    private String otherArtistJson = "{\n" +
                                "\t\"genres\": [\"bluegrass\", \"country\", \"country gospel\", \"cowboy western\", \"folk christmas\", \"heavy metal\", \"old-time\", \"progressive bluegrass\", \"traditional metal\"],\n" +
                                "\t\"href\": \"https://api.spotify.com/v1/artists/1234fANRpZbnxdstzcNg5H\",\n" +
                                "\t\"id\": \"1234fANRpZbnxdstzcNg5H\",\n" +
                                "\t\"name\": \"Bill Monroe\",\n" +
                                "\t\"popularity\": 42,\n" +
                                "\t\"type\": \"artist\",\n" +
                                "\t\"uri\": \"spotify:artist:1234fANRpZbnxdstzcNg5H\"\n" +
                                "}";

    @Override
    public ArtistInfo createObject() throws IOException {
        return new ArtistInfo(billMonroeJson);
    }

    @Override
    public ArtistInfo createUnequalObject() throws IOException {
        return new ArtistInfo(otherArtistJson);
    }

}