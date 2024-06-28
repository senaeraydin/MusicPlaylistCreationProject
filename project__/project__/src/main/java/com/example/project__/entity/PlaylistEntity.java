package com.example.project__.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "PLAYLIST")
@ApiModel(value = "Playlist object", description = "Playlist")
public class PlaylistEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("Playlist object's id field")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "playlist_name")
    @ApiModelProperty("Playlist object's name field")
    private String playlistName;

    @ManyToMany
    @JoinTable(name = "artist_enrolled", joinColumns = @JoinColumn(name = "artist_id"),
    inverseJoinColumns = @JoinColumn(name = "playlist_id"))
    @ApiModelProperty("Playlist object's enrolledArtists field")
    private Set<ArtistEntity> enrolledArtists = new HashSet<>();


    @ManyToMany
    @JoinTable(name = "user_enrolled", joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "playlist_id"))
    @ApiModelProperty("Playlist object's enrolledUsers field")
    private Set<UserEntity> enrolledUsers = new HashSet<>();



    @ManyToMany
    @JoinTable(name = "tracks_enrolled", joinColumns = @JoinColumn(name = "track_id"),
    inverseJoinColumns = @JoinColumn(name = "playlist_id"))
    @ApiModelProperty("Playlist object's enrolledTracks field")
    private Set<TrackEntity> enrolledTracks = new HashSet<>();

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    public Set<ArtistEntity> getEnrolledArtists() {
        return enrolledArtists;
    }

    public void enrolledArtist(ArtistEntity artistEntity){
        enrolledArtists.add(artistEntity);
    }


    public PlaylistEntity() {
    }


    public void enrollUser(UserEntity userEntity){
        enrolledUsers.add(userEntity);
    }



    public void enrollTrack(TrackEntity trackEntity){
        enrolledTracks.add(trackEntity);
    }

    public Set<UserEntity> getEnrolledUsers() {
        return enrolledUsers;
    }



    public Set<TrackEntity> getEnrolledTracks() {
        return enrolledTracks;
    }
}
