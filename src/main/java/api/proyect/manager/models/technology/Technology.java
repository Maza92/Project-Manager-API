package api.proyect.manager.models.technology;

import api.proyect.manager.models.course.Course;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Technology {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique=true, nullable=false)
    private String name;

    @ManyToOne
    @JoinColumn(nullable=false, name = "course_id")
    private Course course;
}