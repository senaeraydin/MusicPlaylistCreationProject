package com.example.project__.serviceImpl;

import com.example.project__.entity.ArtistEntity;
import com.example.project__.entity.TrackEntity;
import com.example.project__.repository.ArtistRepository;
import com.example.project__.repository.TrackRepository;
import com.example.project__.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackServiceImpl implements TrackService {

    @Autowired
    private TrackRepository trackRepository;

    @Autowired
    private ArtistRepository artistRepository;
    @Override
    public TrackEntity addTrack(TrackEntity trackEntity) {
        return trackRepository.save(trackEntity);
    }

    @Override
    public void deleteTrackById(Long trackId) {
        trackRepository.deleteById(trackId);
    }

    @Override
    public List<TrackEntity> getAllTracks() {
        return trackRepository.findAll();
    }

    @Override
    public TrackEntity getTrackById(Long trackId) {
        return trackRepository.findById(trackId).get();
    }

    @Override
    public TrackEntity assignTrackToArtist(Long artistid, Long trackid) {
        TrackEntity trackEntity = trackRepository.findById(trackid).get();
        ArtistEntity artist = artistRepository.findById(artistid).get();
        trackEntity.assignArtist(artist);
        return trackRepository.save(trackEntity);
    }
}
