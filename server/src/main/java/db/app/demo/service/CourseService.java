package db.app.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import db.app.demo.models.Course;
import db.app.demo.models.EnrolledCourse;
import db.app.demo.repository.CourseRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Service
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAll() {
        return courseRepository.getAll();
    }

    public Course getById(String id) {
        List<Course> courses = courseRepository.getAll();
        Course course = null;
        for (Course c : courses) {
            if(c.getID().equals(id)) {
                course = c;
            }
        }
        return course;
    }

    public void create(Course course) {
        courseRepository.createCourse(course.getID(), course.getTitle(), course.getDepartmentName(), course.getCredits());
    }

    public void update(Course course) {
        courseRepository.setCourseCredits(course.getID(), course.getCredits());
        courseRepository.setCourseDepartment(course.getID(), course.getDepartmentName());
        courseRepository.setCourseTitle(course.getID(), course.getTitle());
    }

    public void delete(String id) {
        courseRepository.deleteCourse(id);
    }

    public List<EnrolledCourse> getEnrolledCourses(String id) {
        return courseRepository.getCourseTakes(id);
    }
}
