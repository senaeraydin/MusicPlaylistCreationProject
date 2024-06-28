package com.example.project__.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.management.relation.Role;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "USERS")
@ApiModel(value = "User object", description = "User")
public class UserEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("User object's id field")
    private Long id;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "user_namesurname")
    @ApiModelProperty("User object's name and surname field")
    private String name;

    @Column(name = "user_username")
    @ApiModelProperty("User object's username field")
    private String username;

    @Column(name = "user_email")
    @ApiModelProperty("User object's email field")
    private String email;
    @Column(name = "user_password")
    @ApiModelProperty("User object's password field")
    private String password;

    @JsonIgnore
    @ManyToMany(mappedBy = "enrolledUsers")
    @ApiModelProperty("User object's playlists field")
    Set<PlaylistEntity> playlists = new HashSet<>();

    public UserEntity() {
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<PlaylistEntity> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(Set<PlaylistEntity> playlists) {
        this.playlists = playlists;
    }
}
