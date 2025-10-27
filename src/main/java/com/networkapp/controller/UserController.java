package com.networkapp.controller;

import com.networkapp.dto.UpdateUserProfileRequest;
import com.networkapp.dto.UserProfileResponse;
import com.networkapp.service.UserService;
import com.networkapp.service.JwtService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;
    private final JwtService jwtService;

    public UserController(UserService userService, JwtService jwtService) {
        this.userService = userService;
        this.jwtService = jwtService;
    }

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/profile")
    public UserProfileResponse getProfile(@AuthenticationPrincipal UserDetails userDetails) {
        return userService.getProfileByEmail(userDetails.getUsername());
    }

    @PutMapping("/profile")
    public UserProfileResponse updateProfile(
        @AuthenticationPrincipal UserDetails userDetails,
        @RequestBody UpdateUserProfileRequest request){
            return userService.updateProfileByEmail(userDetails.getUsername() , request);
        }
    
}
