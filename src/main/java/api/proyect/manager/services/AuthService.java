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
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public User registerUser(UserRegisterDto userRegisterDto) {
        Role role = roleRepository.findByName(RoleName.USER);
        if (role == null) {
            System.out.println("role not found");
        }

        Set<Role> roles = new HashSet<>();
        roles.add(role);

        User user = User.builder()
                .username(userRegisterDto.getUsername())
                .email(userRegisterDto.getEmail())
                .password(passwordEncoder.encode(userRegisterDto.getPassword()))
                .roles(roles)
                .createAt(new Date(System.currentTimeMillis()))
                .updateAt(null)
                .build();

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
