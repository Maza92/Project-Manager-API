package api.proyect.manager.models.progress;

import api.proyect.manager.models.Lesson.Lesson;
import api.proyect.manager.models.user.User;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Progress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Boolean completed;
    private Date lastAccessDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;
}