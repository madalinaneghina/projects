package com.endava.internship.rest.service;

import com.endava.internship.rest.model.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArtistsService {

    public List<Artist> getArtists() {
        List<Artist> artists = new ArrayList<>();

        artists.add(new Artist(1, "Artist 1"));
        artists.add(new Artist(2, "Artist 2"));

        return artists;
    }

    public Artist getArtistById(Integer artistId) {
        return new Artist(artistId, "Artist " + artistId);
    }
}
