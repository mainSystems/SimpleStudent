package main.systems.SimpleStudent.persistence.service;

import lombok.RequiredArgsConstructor;
import main.systems.SimpleStudent.persistence.entity.Student;
import main.systems.SimpleStudent.persistence.repository.StudentRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{
    private final StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }
    @Override
    public Student getStudent(Long id) {
        return studentRepository.getStudent(id);
    }

    @Override
    public void delStudent(Long id) {
        studentRepository.delStudent(id);
    }

    @Override
    public String getStudentName(Long id) {
        return studentRepository.getStudentName(id);
    }

    @Override
    public int getStudentAge(Long id) {
        return studentRepository.getStudentAge(id);
    }

    @Override
    public void setMarkById(Long id, int mark) {
        studentRepository.setMarkById(id, mark);
    }

    @Override
    public void setNameById(Long id, String name) {
        studentRepository.setNameById(id, name);
    }

    @Override
    public void setAgeById(Long id, int age) {
        studentRepository.setAgeById(id, age);
    }
}
