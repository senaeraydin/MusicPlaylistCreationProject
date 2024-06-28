package com.example.project__.serviceImpl;

import com.example.project__.entity.PlaylistEntity;
import com.example.project__.entity.UserEntity;
import com.example.project__.repository.PlaylistRepository;
import com.example.project__.repository.UserRepository;
import com.example.project__.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PlaylistRepository playlistRepository;


    @Override
    public UserEntity addUser(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    @Override
    public List<UserEntity> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity getUserById(Long userId) {
        return userRepository.findById(userId).get();
    }

    @Override
    public void deleteUserById(Long userId) {
        userRepository.deleteById(userId);

    }

    @Override
    public PlaylistEntity enrolluserToPlaylist(Long playlistId, Long userId) {
        PlaylistEntity playlistEntity = playlistRepository.findById(playlistId).get();
        UserEntity user = userRepository.findById(userId).get();
        playlistEntity.enrollUser(user);
        return playlistRepository.save(playlistEntity);
    }

    @Override
    public boolean isThereAUser(String username, String password) {
        // todo userName Boş değilse
        UserEntity user = userRepository.findByUsername(username);

        if (Objects.equals(password, user.getPassword())) {
            return true;
        } else
            return false;

    }


}
