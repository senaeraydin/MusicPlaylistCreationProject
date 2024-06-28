package com.example.project__.controller;

import com.example.project__.entity.PlaylistEntity;
import com.example.project__.repository.ArtistRepository;
import com.example.project__.repository.PlaylistRepository;
import com.example.project__.repository.TrackRepository;
import com.example.project__.repository.UserRepository;
import com.example.project__.service.PlaylistService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Api(value = "Playlist API documentation")
public class PlaylistController {

    @Autowired
    private PlaylistService playlistService;

    @Autowired
    private PlaylistRepository playlistRepository;

    @Autowired
    private ArtistRepository artistRepository;


    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TrackRepository trackRepository;



    @PostMapping("/savePlaylist")
    @ApiOperation(value = "Add Playlist method")
    public @ApiResponse ResponseEntity<PlaylistEntity> addPlaylist(@RequestBody @ApiParam("playlistEntity") PlaylistEntity playlistEntity){
        PlaylistEntity playlist = playlistService.addPlaylist(playlistEntity);
        return new ResponseEntity<PlaylistEntity>(playlist, HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    @ApiOperation(value = "Show all playlists method")
    public @ApiResponses ResponseEntity<List<PlaylistEntity>> getAllPlaylists(){
        List<PlaylistEntity> allPlaylists= playlistService.findAllPlaylists();
        return new ResponseEntity<List<PlaylistEntity>>(allPlaylists, HttpStatus.OK);
    }


    @GetMapping("/{plid}")
    @ApiOperation(value = "Show playlist by their id method")
    public @ApiResponse ResponseEntity<PlaylistEntity> getPlaylistById(@PathVariable("plid") @ApiParam("id") long id){
        PlaylistEntity playlistById = playlistService.getPlaylistById(id);
        return new ResponseEntity<PlaylistEntity>(playlistById, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{plid}")
    @ApiOperation(value = "Delete playlist by id method")
    public @ApiResponse ResponseEntity<Void> deletePlaylistById(@PathVariable("plid") @ApiParam("id") Long id){
        playlistService.deletePlaylistById(id);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }

    @PutMapping("/{playlistId}")
    @ApiOperation(value = "Update playlist name method")
    public @ApiResponse ResponseEntity<PlaylistEntity> updatePlaylistName(@PathVariable @ApiParam("playlistId") Long playlistId,
                                                                          @RequestBody @ApiParam("name") String name){
        PlaylistEntity updatename = playlistService.updatePlaylistById(playlistId, name);
        return new ResponseEntity<PlaylistEntity>(updatename, HttpStatus.OK);
    }


    @PutMapping("/enroll/{playlistId}/artist/{artistId}")
    @ApiOperation(value = "Enroll artists to playlist  method")
    public @ApiResponse PlaylistEntity enrollArtistsToPlaylist(@PathVariable @ApiParam("playlistId") Long playlistId,
                                             @PathVariable @ApiParam("artistId") Long artistId){
        return this.playlistService.enrollArtistsToPlaylist(playlistId,artistId);
    }
    @PutMapping("/withdraw/{playlistId}/artists/{artistId}")
    @ApiOperation(value = "Withdraw artists to playlist method")
    public @ApiResponse ResponseEntity<Void> withdrawArtistsToPlaylist(@PathVariable @ApiParam("playlistId") Long playlistId,
                                           @PathVariable @ApiParam("artistId") Long artistId){
        playlistService.withdrawArtistsToPlaylist(playlistId,artistId);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }

/*
    @PutMapping("/{playlistId}/user/{userId}")
    @ApiOperation(value = "enroll users to playlist method")
    public @ApiResponse PlaylistEntity enrollUsersToPlaylist(@PathVariable @ApiParam("playlistId") Long playlistId,
                                                  @PathVariable @ApiParam("userId") Long userId){

        return this.playlistService.enrolluserToPlaylist(playlistId, userId);
    }

 */




    @PutMapping("/enrollTrack/{playlistId}/track/{trackId}")
    @ApiOperation(value = "Enroll tracks to playlist method")
    public PlaylistEntity enrollTracksToPlaylist(@PathVariable @ApiParam("playlistId") Long playlistId,
                                                  @PathVariable @ApiParam("trackId") Long trackId){
        return this.playlistService.enrollTracksToPlaylist(playlistId,trackId);
    }





}
