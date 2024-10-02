package api.proyect.manager.model.user.dto;

import lombok.Data;

@Data
public class UserLoginDto {
    private String email;
    private String password;
}
