package com.example.project__.service;

import com.example.project__.entity.TrackEntity;

import java.util.List;

public interface TrackService {
    public TrackEntity addTrack(TrackEntity trackEntity);
    public void deleteTrackById(Long trackId);

    public List<TrackEntity> getAllTracks();

    public TrackEntity getTrackById(Long trackId);

    public TrackEntity assignTrackToArtist(Long artistid,Long trackid);


}
