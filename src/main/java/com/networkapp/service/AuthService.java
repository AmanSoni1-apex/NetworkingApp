package com.networkapp.service;


import com.networkapp.dto.AuthResponse;
import com.networkapp.dto.LoginRequest;
import com.networkapp.dto.RegisterRequest;
import com.networkapp.model.User;
import com.networkapp.repository.UserRepository;
import com.networkapp.util.JwtUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

     public AuthService(UserRepository userRepository, JwtUtil jwtUtil)
    {
        this.userRepository= userRepository;
        this.jwtUtil = jwtUtil;
    }

    public void register(RegisterRequest request)
    {
        if(userRepository.findByEmail(request.getEmail()).isPresent())
        {
            throw new RuntimeException("Email already exist");
        }

        User user = User.builder().email(request.getEmail()).password(passwordEncoder.encode(request.getPassword())).build();
        userRepository.save(user);
    }

    public AuthResponse login(LoginRequest request)
    {
        User user =  userRepository.findByEmail(request.getEmail()).orElseThrow(()-> new RuntimeException("Invalid credentials"));
        if(!passwordEncoder.matches(request.getPassword(), user.getPassword())){
            throw new RuntimeException("Invalid credentials");
        }
        String token = jwtUtil.generateToken(user.getEmail());
        AuthResponse response = new AuthResponse();
        response.setToken(token);
        return response;
    }
}
