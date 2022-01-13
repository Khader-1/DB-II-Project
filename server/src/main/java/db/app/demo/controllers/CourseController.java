package db.app.demo.controllers;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import db.app.demo.models.Course;
import db.app.demo.service.CourseService;
import db.app.demo.service.DepartmentService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Controller
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    public CourseService coursesService;

    @Autowired
    public DepartmentService departmentsService;

    @GetMapping("/")
    @Transactional
    public String index(Model model) {
        model.addAttribute("courses", coursesService.getAll());
        return "course/index";   
    }

    @GetMapping("/create")
    @Transactional
    public String create(Model model) {
        model.addAttribute("departments", departmentsService.getAllNames());
        return "course/create";   
    }

    @PostMapping("/")
    @Transactional
    public String create(Course course) {
        coursesService.create(course);
        return "redirect:/courses/";   
    }

    @GetMapping("/edit/{id}")
    @Transactional
    public String edit(Model model, @PathVariable("id") String id) {
        model.addAttribute("course", coursesService.getById(id));
        model.addAttribute("departments", departmentsService.getAllNames());
        return "course/edit";   
    }

    @PostMapping("/{id}")
    @Transactional
    public String update(Course course) {
        coursesService.update(course);
        return "redirect:/courses/";   
    }

    @GetMapping("delete/{id}")
    @Transactional
    public String delete(@PathVariable("id") String id) {
        coursesService.delete(id);
        return "redirect:/courses/";   
    }
    
}