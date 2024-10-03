package api.proyect.manager.repositories;

import api.proyect.manager.models.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    Course findByTitle(String title);
}
