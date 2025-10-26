package com.networkapp.model;

import jakarta.persistence.*;
import lombok.*;

//  The user.java file is used to represent the user in the app , everytime a user register or login in the app it was stored as a user
@Entity
@Table(name="user")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true , nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    private String username;
    private String bio;
    private String profilePicture;


    public User(String email, String password, String username, String bio, String profilePicture) {
        this.email = email;
        this.password = password;
        this.username = username;
        this.bio = bio;
        this.profilePicture = profilePicture;
    }

   
    public Long getId() { return id; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getBio() { return bio; }
    public void setBio(String bio) { this.bio = bio; }

    public String getProfilePicture() { return profilePicture; }
    public void setProfilePicture(String profilePicture) { this.profilePicture = profilePicture; }
}
