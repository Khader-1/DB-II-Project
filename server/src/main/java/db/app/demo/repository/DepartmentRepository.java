package db.app.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import db.app.demo.models.Department;

public interface DepartmentRepository extends JpaRepository<Department, String> {

    @Procedure(procedureName = "department_pkg.Get_Dept_Name", outputParameterName = "c_course", refCursor = true)
    List<String> getAllNames();

}
