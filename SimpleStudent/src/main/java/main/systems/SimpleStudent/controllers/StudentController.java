package main.systems.SimpleStudent.controllers;

import lombok.RequiredArgsConstructor;
import main.systems.SimpleStudent.persistence.entity.Student;
import main.systems.SimpleStudent.persistence.entity.dto.StudentDto;
import main.systems.SimpleStudent.persistence.service.StudentServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/studies")
@RequiredArgsConstructor
public class StudentController {
    private final StudentServiceImpl studentService;

    @GetMapping("/mainPage")
    public List<StudentDto> getStudents() {
        return studentService.getAllStudents().stream().map(student -> new StudentDto(student)).toList();
    }

    @GetMapping("/student/{id}")
    public StudentDto getStudentById(@PathVariable(name = "id") Long id) {
        return new StudentDto(studentService.getStudent(id));
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
