package db.app.demo.controllers;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import db.app.demo.repository.StudentRepository;
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
    public StudentRepository studnetsRepo;

    @GetMapping("/")
    @Transactional
    public String index(Model model) {
        model.addAttribute("students", studnetsRepo.getAll());
        return "student/index";   
    }

    @GetMapping("/edit/{id}")
    @Transactional
    public String edit(Model model, @PathVariable("id") String id) {
        // model.addAttribute("student", studnetsRepo.getById(id));
        return "student/edit";   
    }
}