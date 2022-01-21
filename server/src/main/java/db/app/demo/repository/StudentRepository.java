package db.app.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import db.app.demo.models.EnrolledCourse;
import db.app.demo.models.Student;

public interface StudentRepository extends JpaRepository<Student, String> {

    @Procedure(procedureName = "student_pkg.register_student")
    void register(@Param("id") String id,
            @Param("name") String name,
            @Param("dept_name") String department,
            @Param("tot_cred") Double totalCredits);

    @Procedure(procedureName = "student_pkg.set_name")
    void setName(@Param("ids") String id, @Param("s_name") String name);

    @Procedure(procedureName = "student_pkg.set_department_name")
    void setDepartment(@Param("ids") String id, @Param("s_dept_name") String name);

    @Procedure(procedureName = "student_pkg.set_total_cerdit")
    void setTotalCredits(@Param("ids") String id, @Param("s_totalcerdit") Double totalCredits);

    @Procedure(procedureName = "student_pkg.delete_student")
    void deleteStudent(@Param("s_id") String id);

    @Procedure
    List<Student> getAll();

    @Procedure
    List<EnrolledCourse> getStudentCourses(@Param("s_id") String id);

}
