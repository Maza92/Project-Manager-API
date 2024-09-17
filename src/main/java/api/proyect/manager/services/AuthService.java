package api.proyect.manager.services;

import api.proyect.manager.models.enums.Role;
import api.proyect.manager.models.user.User;
import api.proyect.manager.models.user.UserLoginDto;
import api.proyect.manager.models.user.UserRegisterDto;
import api.proyect.manager.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public User registerUser(UserRegisterDto userRegisterDto) {
        User user = new User();
        user.setUsername(userRegisterDto.getUsername());
        user.setEmail(userRegisterDto.getEmail());
        user.setPassword(passwordEncoder.encode(userRegisterDto.getPassword()));
        user.setRole(Role.USER);
        user.setCreateAt(new Date(System.currentTimeMillis()));
        user.setCreateAt(null);
        return userRepository.save(user);
    }
    public User authenticate(UserLoginDto userLoginDto) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userLoginDto.getEmail(), userLoginDto.getPassword()
                )
        );

        return userRepository.findByEmail(userLoginDto.getEmail()).orElseThrow();
    }
}
