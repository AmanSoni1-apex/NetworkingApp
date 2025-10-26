package com.networkapp.service;

import com.networkapp.dto.UpdateUserProfileRequest;
import com.networkapp.dto.UserProfileResponse;
import com.networkapp.model.User;
import com.networkapp.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // fetch profile
    public UserProfileResponse getProfile(Long userId) {
        User user = userRepository.findById(userId)
                     .orElseThrow(() -> new RuntimeException("User not found"));
        return new UserProfileResponse(user.getId(), user.getUsername(), user.getEmail(),user.getBio(), user.getProfilePicture());
    }

    // update profile
    public UserProfileResponse updateProfile(Long userId, UpdateUserProfileRequest request) {
        User user = userRepository.findById(userId)
                     .orElseThrow(() -> new RuntimeException("User not found"));

        if(request.getUsername() != null) user.setUsername(request.getUsername());
        if(request.getBio() != null) user.setBio(request.getBio());
        if(request.getProfilePicture() != null) user.setProfilePicture(request.getProfilePicture());

        userRepository.save(user);

        return new UserProfileResponse(user.getId(), user.getUsername(), user.getEmail(),user.getBio(), user.getProfilePicture());
    }
}
