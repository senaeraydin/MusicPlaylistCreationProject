package com.example.project__.service;

import com.example.project__.entity.ArtistEntity;
import com.example.project__.entity.PlaylistEntity;

import java.util.List;

public interface ArtistService {
    public ArtistEntity addArtist(ArtistEntity artistEntity);

    public List<ArtistEntity> findAllArtists();

    public ArtistEntity getArtistById(Long artistId);

    public void deleteArtistById(Long artistId);
}
