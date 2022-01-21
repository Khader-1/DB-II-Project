package db.app.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
public class EnrolledCourse {
    @Id
    @Column(name = "COURSE ID")
    private String courseID;
    @Column(name = "STUDENT ID")
    private String studentID;
    @Column(name = "SECTION ID")
    private String sectionID;
    @Column(name = "SEMESTER")
    private String semester;
    @Column(name = "YEAR")
    private int year;
    @Column(name = "GRADE")
    private String grade;

}
