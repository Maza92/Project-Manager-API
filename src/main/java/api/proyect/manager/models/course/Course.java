package api.proyect.manager.models.course;

import api.proyect.manager.models.Lesson.Lesson;
import api.proyect.manager.models.enrollment.Enrollment;
import api.proyect.manager.models.enums.Level;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private String description;
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private Level level;

    private String category;

    @OneToMany(mappedBy = "course")
    private List<Lesson> lessons;

    @OneToMany(mappedBy = "course")
    private List<Enrollment> enrollments;
}