package api.proyect.manager.models.course;

import api.proyect.manager.models.Lesson.Lesson;
import api.proyect.manager.models.enrollment.Enrollment;
import api.proyect.manager.models.enums.Level;
import api.proyect.manager.models.technology.Technology;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private BigDecimal price;
    private String videoPreview;
    private String teacherName;

    @Enumerated(EnumType.STRING)
    private Level level;
    private String category;

    @OneToMany(mappedBy = "course")
    private List<Lesson> lessons;

    @OneToMany(mappedBy = "course")
    private List<Enrollment> enrollments;

    @ManyToMany
    @JoinTable(
            name = "course_technology",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "technology_id")
    )
    private Set<Technology> technologies = new HashSet<>();

}