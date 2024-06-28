package com.example.project__.controller;

import com.example.project__.entity.ArtistEntity;
import com.example.project__.entity.PlaylistEntity;
import com.example.project__.entity.TrackEntity;
import com.example.project__.repository.ArtistRepository;
import com.example.project__.repository.TrackRepository;
import com.example.project__.service.TrackService;
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
@RequestMapping("/apiTrack")
@Api(value = "Track API documentation")
public class TrackController {

    @Autowired
    private TrackService trackService;


    @PostMapping("/saveTrack")
    @ApiOperation(value = "Add track method")
    public @ApiResponse ResponseEntity<TrackEntity> addTrack(@RequestBody @ApiParam("trackEntity")  TrackEntity trackEntity){
        TrackEntity track = trackService.addTrack(trackEntity);
        return new ResponseEntity<TrackEntity>(track, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteTrack/{id}")
    @ApiOperation(value = "Delete track by id method")
    public @ApiResponse ResponseEntity<Void> deleteTrackById(@PathVariable("id") @ApiParam("id")  Long id){
        trackService.deleteTrackById(id);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }

    @GetMapping("/getTracks")
    @ApiOperation(value = "Show all tracks method")
    public @ApiResponse ResponseEntity<List<TrackEntity>> getAllTracks(){
        List<TrackEntity> trackEntityList = trackService.getAllTracks();
        return new ResponseEntity<List<TrackEntity>>(trackEntityList, HttpStatus.OK);
    }

    @GetMapping("/{trid}")
    @ApiOperation(value = "Show track by id method")
    public @ApiResponse ResponseEntity<TrackEntity> getTrackById(@PathVariable("trid")  @ApiParam("id") Long id ){
        TrackEntity trackEntity = trackService.getTrackById(id);
        return new ResponseEntity<TrackEntity>(trackEntity, HttpStatus.OK);
    }

    @PutMapping("/{artistid}/track/{trackid}")
    @ApiOperation(value = "Assing track to artist method")
    public @ApiResponse TrackEntity assignTrackToArtist(@PathVariable  @ApiParam("artitsid") Long artistid,
                                                  @PathVariable  @ApiParam("trackid") Long trackid){
        return this.trackService.assignTrackToArtist(artistid,trackid);
    }

}
