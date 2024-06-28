package com.example.project__.controller;

import com.example.project__.entity.PlaylistEntity;
import com.example.project__.entity.UserEntity;
import com.example.project__.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apiUser")
@Api(value = "User API documentation")
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping("/saveUser")
    @ApiOperation(value = "Add user method")
    public @ApiResponse ResponseEntity<UserEntity> addUser(@RequestBody @ApiParam("userEntity") UserEntity userEntity){
        UserEntity user = userService.addUser(userEntity);
        return new ResponseEntity<UserEntity>(user, HttpStatus.CREATED);
    }

    @GetMapping("/getUsers")
    @ApiOperation(value = "Show all users method")
    public @ApiResponse  ResponseEntity<List<UserEntity>> getAllUsers(){
        List<UserEntity> userEntities = userService.findAllUsers();
        return new ResponseEntity<List<UserEntity>>(userEntities, HttpStatus.OK);
    }

    @GetMapping("/{usid}")
    @ApiOperation(value = "Show user by id method")
    public @ApiResponse ResponseEntity<UserEntity> getUserById(@PathVariable("usid")  @ApiParam("userid") Long userId){
        UserEntity userById = userService.getUserById(userId);
        return new ResponseEntity<UserEntity>(userById, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{usid}")
    @ApiOperation(value = "Delete user by id method")
    public @ApiResponse  ResponseEntity<Void> deleteUserById(@PathVariable("usid")  @ApiParam("userid") Long userId){
        userService.deleteUserById(userId);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }

    @PutMapping("/{playlistId}/user/{userId}")
    @ApiOperation(value = "enroll users to playlist method")
    public @ApiResponse PlaylistEntity enrollUsersToPlaylist(@PathVariable @ApiParam("playlistId") Long playlistId,
                                                             @PathVariable @ApiParam("userId") Long userId){

        return this.userService.enrolluserToPlaylist(playlistId, userId);
    }

    @PutMapping("/username/{username}/password/{password}")
    @ApiOperation(value = "user login method" )
    public @ApiResponse String loginUser(@PathVariable @ApiParam("username") String username,
                                         @PathVariable @ApiParam("password") String password){
       if(userService.isThereAUser(username, password)){
           return "User login successed!";
       } else
           return "User can not login";
    }



}
