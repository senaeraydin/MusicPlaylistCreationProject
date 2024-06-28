package com.example.project__.serviceImpl;

import com.example.project__.entity.ArtistEntity;
import com.example.project__.entity.PlaylistEntity;
import com.example.project__.entity.TrackEntity;
import com.example.project__.entity.UserEntity;
import com.example.project__.repository.ArtistRepository;
import com.example.project__.repository.PlaylistRepository;
import com.example.project__.repository.TrackRepository;
import com.example.project__.repository.UserRepository;
import com.example.project__.service.PlaylistService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static ch.qos.logback.core.joran.action.ActionConst.NULL;

@Service
public class PlaylistServiceImpl implements PlaylistService {

    private PlaylistRepository playlistRepository;


    private TrackRepository trackRepository;


    private UserRepository userRepository;


    private ArtistRepository artistRepository;


    @Override
    public PlaylistEntity addPlaylist(PlaylistEntity playlistEntity) {
        return playlistRepository.save(playlistEntity);
    }

    @Override
    public List<PlaylistEntity> findAllPlaylists() {
        return playlistRepository.findAll();
    }

    @Override
    public PlaylistEntity getPlaylistById(Long playlistId) {
        return playlistRepository.findById(playlistId).get();

    }

    @Override
    public void deletePlaylistById(Long playlistId) {
        playlistRepository.deleteById(playlistId);
    }

    @Override
    public PlaylistEntity updatePlaylistById(Long playlistId, String newName) {
        Optional<PlaylistEntity> queryResult = playlistRepository.findById(playlistId);
        PlaylistEntity playlistEntity = queryResult.get();
        if(newName != NULL){
            playlistEntity.setPlaylistName(newName);
        }

        return playlistEntity;
    }

/*
    @Override
    public PlaylistEntity enrolluserToPlaylist(Long playlistId, Long userId) {
        PlaylistEntity playlistEntity = playlistRepository.findById(playlistId).get();
        UserEntity user = userRepository.findById(userId).get();
        playlistEntity.enrollUser(user);
        return playlistRepository.save(playlistEntity);
    }


 */

    @Override
    public PlaylistEntity enrollArtistsToPlaylist(Long playlistId, Long artistId) {
        PlaylistEntity playlistEntity = playlistRepository.findById(playlistId).get();
        ArtistEntity artist = artistRepository.findById(artistId).get();
        playlistEntity.enrolledArtist(artist);
        return playlistRepository.save(playlistEntity);
    }

    @Override
    public void withdrawArtistsToPlaylist(Long playlistId, Long artistId) {
        PlaylistEntity playlistEntity = playlistRepository.findById(playlistId).get();
        ArtistEntity artist = artistRepository.findById(artistId).get();
        playlistEntity.enrolledArtist(artist);
        playlistRepository.delete(playlistEntity);
    }

    @Override
    public PlaylistEntity enrollTracksToPlaylist(Long playlistId, Long trackId) {
        PlaylistEntity playlistEntity = playlistRepository.findById(playlistId).get();
        TrackEntity track = trackRepository.findById(trackId).get();
        playlistEntity.enrollTrack(track);
        return playlistRepository.save(playlistEntity);
    }



    /*
    @Override
    public void addTrackToPlaylist(Long playlistId, Long trackid) {
        Optional<PlaylistEntity> queryResultPlaylist = playlistRepository.findById(playlistId);
        Optional<TrackEntity> queryResultTrack = trackRepository.findById(trackid);

        PlaylistEntity playlistEntity = queryResultPlaylist.get();
        TrackEntity trackEntity = queryResultTrack.get();
        playlistEntity.getTracks().add(trackEntity);
        playlistRepository.save(playlistEntity);
    }

    @Override
    public void deleteTrackFromPlaylist(Long playlistId, Long trackid) {
        Optional<PlaylistEntity> queryResultPlaylist = playlistRepository.findById(playlistId);
        Optional<TrackEntity> queryResultTrack = trackRepository.findById(trackid);

        PlaylistEntity playlistEntity = queryResultPlaylist.get();
        TrackEntity trackEntity=queryResultTrack.get();
        playlistEntity.getTracks().remove(trackEntity);
        playlistRepository.save(playlistEntity);
    }

     */



    /*
    @Override
    public PlaylistEntity getPlaylistByUserId(Long userid) {

        Optional<UserEntity> userEntity = userRepository.findById(userid);
        UserEntity userEntity1 = userEntity.get();


    }

     */




}
