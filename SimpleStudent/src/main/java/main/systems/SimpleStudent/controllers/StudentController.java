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

    @DeleteMapping("/student")
    public void delStudent(@RequestParam Long id) {
        studentService.delStudent(id);
    }

    @GetMapping("/studentMark")
    public long getStudentMark(@RequestParam Long id) {
        return studentService.getStudentMark(id);
    }

    @PostMapping("/studentMark")
    public void changeStudentMark(@RequestParam Long id, @RequestParam int mark) {
        studentService.updateMarkById(id, mark);
    }

    @PostMapping("/student")
    public void addStudent(@RequestParam String name, @RequestParam(required = false, defaultValue = "0") int age) {
        studentService.addStudent(name, age);
    }
}
