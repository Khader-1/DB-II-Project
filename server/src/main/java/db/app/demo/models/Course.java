package db.app.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "Course.getAll", procedureName = "course_pkg.get_all_courses", resultClasses = Course.class, parameters = {
                @StoredProcedureParameter(name = "allcourse", mode = ParameterMode.REF_CURSOR, type = void.class) }),
        @NamedStoredProcedureQuery(name = "Course.getCourseTakes", procedureName = "course_pkg.get_course_takes", resultClasses = EnrolledCourse.class, parameters = {
                @StoredProcedureParameter(name = "c_course", mode = ParameterMode.REF_CURSOR, type = void.class),
                @StoredProcedureParameter(name = "c_id", mode = ParameterMode.IN, type = String.class),
        }),
})
public class Course {
    @Id
    @Column(name = "COURSE ID")
    private String ID;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "DEPARTMENT NAME")
    private String departmentName;
    @Column(name = "CREDITS")
    private Double credits;

}
