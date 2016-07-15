package com.endava.internship.rest.controller;

import com.endava.internship.rest.model.Artist;
import com.endava.internship.rest.model.HelloMessage;
import com.endava.internship.rest.service.ArtistsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.print.attribute.standard.Media;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping(path = "/artists", produces = MediaType.APPLICATION_JSON_VALUE)
public class ArtistsController {

    @Autowired
    private ArtistsService artistsService;

    @RequestMapping(method = RequestMethod.GET)
    public HttpEntity<Resources<Resource<Artist>>> getArtists() {
        List<Artist> artists = this.artistsService.getArtists();

        Resources<Resource<Artist>> artistResources = Resources.wrap(artists);

        artistResources.add(linkTo(methodOn(ArtistsController.class).getArtists()).withRel("custom-self"));

        artistResources.forEach((artistResource -> {
            artistResource.add(linkTo(methodOn(ArtistsController.class)
                    .getArtist(artistResource.getContent().getId())).withRel("custom-self"));
        }));

        return new ResponseEntity<>(artistResources, HttpStatus.OK);
    }

    @RequestMapping(path = "/{artistId}", method = RequestMethod.GET)
    public HttpEntity<Resource<Artist>> getArtist(@PathVariable Integer artistId) {
        Artist artist = this.artistsService.getArtistById(artistId);

        Resource<Artist> artistResource = new Resource<>(artist);
        artistResource.add(linkTo(methodOn(ArtistsController.class).getArtist(artistId)).withRel("another-self"));

        return new ResponseEntity<>(artistResource, HttpStatus.OK);
    }

}
