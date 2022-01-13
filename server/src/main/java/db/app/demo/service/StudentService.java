package db.app.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import db.app.demo.models.Student;
import db.app.demo.repository.StudentRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentService {
    
    @Autowired
    private StudentRepository studnetsRepo;

    public List<Student> getAll() {
        return studnetsRepo.getAll();
    }

    public Student getById(String id) {
        List<Student> students = studnetsRepo.getAll();
        Student student = null;
        for (Student s : students) {
            if (s.getID().equals(id)) {
                student = s;
            }
        }
        return student;
    }

    public void update(Student student) {
        studnetsRepo.setDepartment(student.getID(), student.getDepartmentName());
        studnetsRepo.setName(student.getID(), student.getName());
        studnetsRepo.setTotalCredits(student.getID(), student.getTotalCerdit());
    }

    public void delete(String id) {
        studnetsRepo.deleteStudent(id);
    }

    public void create(Student student) {
        studnetsRepo.register(student.getID(), student.getName(), student.getDepartmentName(), student.getTotalCerdit());
    }
    
}
