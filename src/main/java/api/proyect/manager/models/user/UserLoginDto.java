package api.proyect.manager.models.user;

import lombok.Data;

@Data
public class UserLoginDto {
    private String email;
    private String password;
}
