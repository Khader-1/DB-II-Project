package db.app.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import db.app.demo.models.Course;
import db.app.demo.models.EnrolledCourse;

@Repository
public interface CourseRepository extends JpaRepository<Course, String> {

    @Procedure(procedureName = "course_pkg.create_course")
    void createCourse(
            @Param("c_course_id") String courseId,
            @Param("c_title") String title,
            @Param("dept_name") String department,
            @Param("c_credits") Double credits);

    @Procedure(procedureName = "course_pkg.delete_course")
    void deleteCourse(@Param("c_id") String id);

    @Procedure(procedureName = "course_pkg.set_cerdits")
    void setCourseCredits(@Param("course_idc") String id, @Param("c_credits") Double credits);

    @Procedure(procedureName = "course_pkg.set_department_name")
    void setCourseDepartment(@Param("course_idc") String id, @Param("s_dept_name") String name);
    
    @Procedure(procedureName = "course_pkg.set_title")
    void setCourseTitle(@Param("course_idc") String id, @Param("s_title") String title);

    @Procedure
    List<Course> getAll();

    @Procedure
    List<EnrolledCourse> getCourseTakes(@Param("c_id") String id);

}
