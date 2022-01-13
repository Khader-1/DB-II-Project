package db.app.demo.controllers;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import db.app.demo.models.Student;
import db.app.demo.service.DepartmentService;
import db.app.demo.service.StudentService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Controller
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping("/students")
public class StudentController {

    @Autowired
    public StudentService studnetsService;

    @Autowired
    public DepartmentService departmentsService;

    @GetMapping("/")
    @Transactional
    public String index(Model model) {
        model.addAttribute("students", studnetsService.getAll());
        return "student/index";   
    }

    @GetMapping("/create")
    @Transactional
    public String create(Model model) {
        model.addAttribute("departments", departmentsService.getAllNames());
        return "student/create";   
    }

    @PostMapping("/")
    @Transactional
    public String create(Student student) {
        studnetsService.create(student);
        return "student/create";   
    }

    @GetMapping("/edit/{id}")
    @Transactional
    public String edit(Model model, @PathVariable("id") String id) {
        model.addAttribute("student", studnetsService.getById(id));
        model.addAttribute("departments", departmentsService.getAllNames());
        return "student/edit";   
    }

    @PostMapping("/{id}")
    @Transactional
    public String update(Student student) {
        studnetsService.update(student);
        return "redirect:/students/";   
    }

    @GetMapping("delete/{id}")
    @Transactional
    public String delete(@PathVariable("id") String id) {
        studnetsService.delete(id);
        return "redirect:/students/";   
    }
    
}