package com.example.project__.controller;

import com.example.project__.entity.ArtistEntity;
import com.example.project__.service.ArtistService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api")
@Api(value = "Artist API documentation")
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    @PostMapping("/saveArtist")
    @ApiOperation(value = "Add artist method")
    public @ApiResponse ResponseEntity<ArtistEntity> addArtist(@RequestBody @ApiParam("artistEntity") ArtistEntity artistEntity){
        ArtistEntity artist = artistService.addArtist(artistEntity);
        return new ResponseEntity<ArtistEntity>(artist, HttpStatus.CREATED);
    }

    @PostMapping("/getArtists")
    @ApiOperation(value = "Show all artists method")
    public @ApiResponse ResponseEntity<List<ArtistEntity>> getAllArtists(){
        List<ArtistEntity> artists = artistService.findAllArtists();
        return new ResponseEntity<List<ArtistEntity>>(artists, HttpStatus.OK);
    }

    @GetMapping("/{arid}")
    @ApiOperation(value = "Show artist by id method")
    public @ApiResponse ResponseEntity<ArtistEntity> getArtistById(@PathVariable("arid") @ApiParam("id")  Long id){
        ArtistEntity artistById = artistService.getArtistById(id);
        return new ResponseEntity<ArtistEntity>(artistById, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{arid}")
    @ApiOperation(value = "Delete artist by id method")
    public @ApiResponse ResponseEntity<Void> deleteArtistById(@PathVariable("arid") @ApiParam("id")  Long id){
        artistService.deleteArtistById(id);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }
}
