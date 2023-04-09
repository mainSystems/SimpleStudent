package main.systems.SimpleStudent.controllers;

import lombok.RequiredArgsConstructor;
import main.systems.SimpleStudent.persistence.entity.Student;
import main.systems.SimpleStudent.persistence.service.StudentServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/studies")
@RequiredArgsConstructor
public class StudentController {
    private final StudentServiceImpl studentService;

    @GetMapping("/mainPage")
    public List<Student> getStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable(name = "id") Long id) {
        return studentService.getStudent(id);
    }
}
