package api.proyect.manager.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class HealthController {

    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return new ResponseEntity<>("UP", HttpStatus.OK);
    }
}
