package api.proyect.manager.model.role;

import api.proyect.manager.model.enums.RoleName;
import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "user_role")
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "role_name")
    private RoleName name;
}
