package api.proyect.manager.services;

import api.proyect.manager.models.Role;
import api.proyect.manager.models.enums.RoleName;
import api.proyect.manager.models.user.User;
import api.proyect.manager.models.user.UserLoginDto;
import api.proyect.manager.models.user.UserRegisterDto;
import api.proyect.manager.repositories.RoleRepository;
import api.proyect.manager.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public User registerUser(UserRegisterDto userRegisterDto) {
        User user = new User();
        try {
            user.setUsername(userRegisterDto.getUsername());
            user.setEmail(userRegisterDto.getEmail());
            user.setPassword(passwordEncoder.encode(userRegisterDto.getPassword()));
            user.getRoles().add(roleRepository.findByName(RoleName.USER.toString()));
            user.setCreateAt(new Date(System.currentTimeMillis()));
            user.setUpdateAt(null);
        } catch (NullPointerException ex) {
            System.out.println("Rol no encontrado");
        }
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
