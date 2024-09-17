package api.proyect.manager.models.user;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Response {
    private String token;
    private long expire;
}
