package com.example.project__.service;

import com.example.project__.entity.PlaylistEntity;
import com.example.project__.entity.UserEntity;
import com.example.project__.repository.PlaylistRepository;
import com.example.project__.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface UserService {


    public UserEntity addUser(UserEntity userEntity);

    public List<UserEntity> findAllUsers();


    public UserEntity getUserById(Long userId);


    public void deleteUserById(Long userId);
    public PlaylistEntity enrolluserToPlaylist(Long playlistId, Long userId);

    boolean isThereAUser(String username, String password);

}
