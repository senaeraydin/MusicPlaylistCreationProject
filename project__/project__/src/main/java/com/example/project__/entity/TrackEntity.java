package com.example.project__.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "TRACK")
@ApiModel(value = "Track object", description = "track")
public class TrackEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("Track object's id field")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @Column(name = "track_name")
    @ApiModelProperty("Track object's name field")
    private String trackName;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "artist_track" , joinColumns = @JoinColumn(name = "artist_id"),
            inverseJoinColumns = @JoinColumn(name = "track_id")
    )
    @ApiModelProperty("Track object's artist field")
    private ArtistEntity artist;

    @JsonIgnore
    @ManyToMany(mappedBy = "enrolledTracks")
    @ApiModelProperty("Track object's tracks field")
    private Set<PlaylistEntity> tracks = new HashSet<>();

/*
    @ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(
            name="users_roles",
            joinColumns={@JoinColumn(name="user_id", referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="role_id", referencedColumnName="id")})
    private List<RoleEntity> roles = new ArrayList<>();

 */
    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public TrackEntity() {
    }

    public void assignArtist(ArtistEntity artistEntity){
        this.artist = artistEntity;
    }
    public ArtistEntity getArtist() {
        return artist;
    }

    public Set<PlaylistEntity> getTracks() {
        return tracks;
    }
}
