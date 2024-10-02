package api.proyect.manager.controller;

import api.proyect.manager.model.TokenResponse;
import api.proyect.manager.model.user.User;
import api.proyect.manager.model.user.dto.UserLoginDto;
import api.proyect.manager.model.user.dto.UserRegisterDto;
import api.proyect.manager.service.AuthService;
import api.proyect.manager.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class LoginController {

    private final JwtService jwtService;
    private final AuthService authService;

    @RequestMapping("/sign-in")
    @PostMapping
    public ResponseEntity<TokenResponse> login(@RequestBody UserLoginDto loginDto) {
        User authUser = authService.authenticate(loginDto);

        String token = jwtService.generateToken(authUser);

        TokenResponse response = new TokenResponse();
        response.setToken(token);
        response.setExpire(jwtService.getExpiration());

        return ResponseEntity.ok(response);
    }

    @RequestMapping("/sign_up")
    @PostMapping
    public ResponseEntity<User> register(@RequestBody UserRegisterDto userRegisterDto) {
        User registerUser = authService.registerUser(userRegisterDto);
        return ResponseEntity.ok(registerUser);
    }

}
