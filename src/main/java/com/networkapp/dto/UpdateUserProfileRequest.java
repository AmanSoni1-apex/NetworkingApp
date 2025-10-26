package com.networkapp.dto;

public class UpdateUserProfileRequest {
    private String username;
    private String bio; 
    private String profilePicture;

    public String getUsername()
    {
        return username;
    }
    public void setUsername(String username)
    {
        this.username=username;
    }

    public String getBio()
    {
        return bio;
    }
    public void setBio(String bio)
    {
        this.bio=bio;
    }

    public String getProfilePicture()
    {
        return profilePicture;
    }
    public void setProfilePicture(String profilePicture)
    {
        this.profilePicture=profilePicture;
    }
}