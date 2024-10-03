package api.proyect.manager.controllers;

import api.proyect.manager.models.course.Course;
import api.proyect.manager.services.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/courses")
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/course")
    public Course getCourseById(@RequestParam String title) {
        return courseService.getCourseByTitle(title);
    }
}
