package com.networkapp.controller;


import com.networkapp.dto.UpdateUserProfileRequest;
import com.networkapp.dto.UserProfileResponse;
import com.networkapp.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    
    private final UserService userService;
    public UserController(UserService userService)
    {
        this.userService=userService;
    }

    @GetMapping("/profile")
    public UserProfileResponse getprofile(@RequestParam Long userId)
    {
        return userService.getProfile(userId);
    }

    @PutMapping("/profile")
    public UserProfileResponse updateProfile(@RequestParam Long userId, @RequestBody UpdateUserProfileRequest request)
    {
        return userService.updateProfile(userId, request);
    }
}
