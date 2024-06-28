package com.example.project__.service;

import com.example.project__.entity.PlaylistEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PlaylistService {
    public PlaylistEntity addPlaylist(PlaylistEntity playlistEntity);
    public List<PlaylistEntity> findAllPlaylists();

    public PlaylistEntity getPlaylistById(Long playlistId);

    public void deletePlaylistById(Long playlistId);

    public PlaylistEntity updatePlaylistById(Long playlistId, String newName);


    //public PlaylistEntity enrolluserToPlaylist(Long playlistId, Long userId);

    public PlaylistEntity enrollArtistsToPlaylist(Long playlistId,Long artistId);

    public void withdrawArtistsToPlaylist(Long playlistId, Long artistId);

    public PlaylistEntity enrollTracksToPlaylist(Long playlistId,Long trackId);


}
