package com.example.project__.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.sound.midi.Track;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "ARTIST")
@ApiModel(value = "artist object", description = "artist")
public class ArtistEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("Artist object's id field")
    private Long id;

    @Column(name = "artist_name")
    @ApiModelProperty("Artist object's name field")
    private String artistName;

   @JsonIgnore
   @ManyToMany(mappedBy = "enrolledArtists")
   @ApiModelProperty("Artist object's playlists field")
    private Set<PlaylistEntity> playlists = new HashSet<>();

   @JsonIgnore
   @OneToMany(mappedBy = "artist")
   @ApiModelProperty("Artist object's tracks field")
   private Set<TrackEntity> tracks = new HashSet<>();
    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public Set<PlaylistEntity> getPlaylists() {
        return playlists;
    }

    public Set<TrackEntity> getTracks() {
        return tracks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ArtistEntity() {
    }





}
