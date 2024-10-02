package api.proyect.manager.controllers;

import api.proyect.manager.models.user.Response;
import api.proyect.manager.models.user.User;
import api.proyect.manager.models.user.UserLoginDto;
import api.proyect.manager.models.user.UserRegisterDto;
import api.proyect.manager.services.AuthService;
import api.proyect.manager.services.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
@CrossOrigin
public class LoginController {

    private final JwtService jwtService;
    private final AuthService authService;

    @RequestMapping("/sign_in")
    @PostMapping
    public ResponseEntity<Response> login(@RequestBody UserLoginDto loginDto) {
        User authUser = authService.authenticate(loginDto);

        String token = jwtService.generateToken(authUser);

        Response response = new Response();
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

    @RequestMapping("/logout")
    public void logout() {
    }
}
