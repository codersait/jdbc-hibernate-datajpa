package com.codersait.controller;

import com.codersait.model.Student;
import com.codersait.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public List<Student> getStudents(){
        return studentService.getAll();
    }

    @PostMapping("/")
    public void loadStudent(@RequestBody Student student){
        studentService.add(student);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable Integer id ){
        studentService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id,@RequestBody Student student){
        studentService.update(id,student);
    }
}
