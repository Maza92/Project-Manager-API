package api.proyect.manager.models.Lesson;

import api.proyect.manager.models.course.Course;
import api.proyect.manager.models.progress.Progress;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private String content;
    private String videoUrl;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @OneToMany(mappedBy = "lesson")
    private List<Progress> progressRecords;
}