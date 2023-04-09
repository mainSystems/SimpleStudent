package main.systems.SimpleStudent.persistence.service;

import main.systems.SimpleStudent.persistence.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student getStudent(Long id);
    void delStudent(Long id);
    String getStudentName(Long id);
    int getStudentAge(Long id);
    int getStudentMark(Long id);
    void setMarkById(Long id, int mark);
    void setNameById(Long id, String name);
    void setAgeById(Long id, int age);
}
