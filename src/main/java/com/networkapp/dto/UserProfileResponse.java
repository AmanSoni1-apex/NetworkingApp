package com.networkapp.dto;

public class UserProfileResponse {
    private Long id;
    private String username;
    private String email;
    private String bio;
    private String profilePicture;

    // 🧱 Constructor with all fields
    public UserProfileResponse(Long id, String username, String email, String bio, String profilePicture) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.bio = bio;
        this.profilePicture = profilePicture;
    }

    // 🧩 Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getBio() { return bio; }
    public void setBio(String bio) { this.bio = bio; }

    public String getProfilePicture() { return profilePicture; }
    public void setProfilePicture(String profilePicture) { this.profilePicture = profilePicture; }
}
