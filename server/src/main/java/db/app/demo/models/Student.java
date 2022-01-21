package db.app.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "Student.getAll", procedureName = "student_pkg.get_all_students", resultClasses = Student.class, parameters = {
                @StoredProcedureParameter(name = "allstudent", mode = ParameterMode.REF_CURSOR, type = void.class) }),
        @NamedStoredProcedureQuery(name = "Student.getStudentCourses", procedureName = "student_pkg.get_student_courses", resultClasses = EnrolledCourse.class, parameters = {
                @StoredProcedureParameter(name = "c_course", mode = ParameterMode.REF_CURSOR, type = void.class),
                @StoredProcedureParameter(name = "s_id", mode = ParameterMode.IN, type = String.class),
        }),
})
public class Student {
    @Id
    @Column(name = "STUDENT ID")
    private String ID;
    @Column(name = "STUDENT NAME")
    private String name;
    @Column(name = "DEPARTMENT NAME")
    private String departmentName;
    @Column(name = "TOTAL CRED")
    private Double totalCerdit;
}
