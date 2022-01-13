package db.app.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import db.app.demo.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Service
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;
    
    public List<String> getAllNames() {
        return departmentRepository.getAllNames();
    }
}
