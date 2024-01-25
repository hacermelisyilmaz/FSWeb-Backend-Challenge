package com.workintech.ecommerce.service.user;

import com.workintech.ecommerce.dto.user.LoginRequest;
import com.workintech.ecommerce.dto.user.UserResponse;
import com.workintech.ecommerce.entity.user.Role;
import com.workintech.ecommerce.entity.user.User;
import com.workintech.ecommerce.repository.user.RoleRepository;
import com.workintech.ecommerce.repository.user.UserRepository;
import com.workintech.ecommerce.util.Converter;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@AllArgsConstructor
@Service
public class AuthenticationService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserResponse register(String fullName, String email, String password) {
        String encodedPassword = passwordEncoder.encode(password);

        Role userRole = roleRepository.findByAuthority("customer").get();
        Set<Role> roles = new HashSet<>();
        roles.add(userRole);

        User user = new User();
        user.setName(fullName);
        user.setEmail(email);
        user.setPassword(encodedPassword);
        user.setAuthorities(roles);

        return Converter.userConverter(userRepository.save(user));
    }

    public UserResponse login(LoginRequest loginRequest){
        Optional<User> optionalUser = userRepository.findUserByEmail(loginRequest.email());
        if(optionalUser.isPresent()){
            User user = optionalUser.get();
            boolean isPasswordSame = passwordEncoder.matches(loginRequest.password(),user.getPassword());
            if(isPasswordSame){
                return Converter.userConverter(user);
            }
        }
        return null;
        //TODO exception handling
    }
}
