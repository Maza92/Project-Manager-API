package api.proyect.manager.services;

import api.proyect.manager.models.course.Course;
import api.proyect.manager.repositories.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CourseService {

    private final CourseRepository courseRepository;


    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseByTitle(String title) {
        return courseRepository.findByTitleIgnoreCase(title);
    }
}
