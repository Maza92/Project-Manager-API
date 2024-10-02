package api.proyect.manager.models.scholarship;

import api.proyect.manager.models.enums.Status;
import api.proyect.manager.models.user.User;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Scholarship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String justification;
    private Date requestDate;
    private Date resolutionDate;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}