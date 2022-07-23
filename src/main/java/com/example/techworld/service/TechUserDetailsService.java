package com.example.techworld.service;

import com.example.techworld.model.entity.UserEntity;
import com.example.techworld.model.entity.UserRoleEntity;
import com.example.techworld.model.user.TechUserDetails;
import com.example.techworld.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class TechUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public TechUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username).map(this::map).orElseThrow(() -> new UsernameNotFoundException("User with Email " + username + " was not found!"));
    }

    private UserDetails map(UserEntity userEntity) {

        return new TechUserDetails(
                userEntity.getId(),
                userEntity.getPassword(),
                userEntity.getEmail(),
                userEntity.getFirstName(),
                userEntity.getLastName(),
                userEntity.getUserRoles().stream().map(this::map).toList()
        );
    }

    private GrantedAuthority map(UserRoleEntity userRole) {
        return new SimpleGrantedAuthority("ROLE_" + userRole.getUserRole().name());
    }
}
