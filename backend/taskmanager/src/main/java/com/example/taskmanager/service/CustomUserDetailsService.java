package com.example.taskmanager.service;

import com.example.taskmanager.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements CustomUserDetails{

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public UserDetails loadUserByUserName(String username)
        throws UsernameNotFoundException {
        User user =userRepository.findByUsername(username)
                .orElseThrow(()->
                            new UsernameNotFoundException(
                                    "user not found" + username
                            )
                        );

        return new CustomUserDetails(user);
    }
}
