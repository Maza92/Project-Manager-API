package api.proyect.manager.models.enrollment;

import api.proyect.manager.models.course.Course;
import api.proyect.manager.models.enums.Status;
import api.proyect.manager.models.user.User;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Date startDate;
    private Date endDate;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
}