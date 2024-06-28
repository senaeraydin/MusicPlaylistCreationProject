package com.example.project__.serviceImpl;

import com.example.project__.entity.ArtistEntity;
import com.example.project__.repository.ArtistRepository;
import com.example.project__.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistServiceImpl implements ArtistService {

    @Autowired
    private ArtistRepository artistRepository;
    @Override
    public ArtistEntity addArtist(ArtistEntity artistEntity) {
        return artistRepository.save(artistEntity);
    }

    @Override
    public List<ArtistEntity> findAllArtists() {
        return artistRepository.findAll();
    }

    @Override
    public ArtistEntity getArtistById(Long artistId) {
        return artistRepository.findById(artistId).get();
    }

    @Override
    public void deleteArtistById(Long artistId) {
        artistRepository.deleteById(artistId);

    }
}
