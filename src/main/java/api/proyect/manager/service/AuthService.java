package api.proyect.manager.service;

import api.proyect.manager.model.TokenResponse;
import api.proyect.manager.model.enums.RoleName;
import api.proyect.manager.model.user.User;
import api.proyect.manager.model.user.dto.UserLoginDto;
import api.proyect.manager.model.user.dto.UserRegisterDto;
import api.proyect.manager.repository.RoleRepository;
import api.proyect.manager.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public TokenResponse registerUser(UserRegisterDto userRegisterDto) {

        final var user = User.builder()
                .username(userRegisterDto.getUsername())
                .email(userRegisterDto.getEmail())
                .password(passwordEncoder.encode(userRegisterDto.getPassword()))
                .build();

        final var userSaved = userRepository.save(user);

        if (userSaved == null) {
            // excepcion
            return null;
        }

        return new TokenResponse(jwtService.generateToken(user), jwtService.getExpiration());
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
