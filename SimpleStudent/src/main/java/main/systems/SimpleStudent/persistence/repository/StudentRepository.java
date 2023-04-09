package main.systems.SimpleStudent.persistence.repository;

import lombok.RequiredArgsConstructor;
import main.systems.SimpleStudent.persistence.entity.Student;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class StudentRepository {
    private final StudentRepositoryDao studentRepositoryDao;

    public List<Student> getAllStudents() {
        return studentRepositoryDao.findAll();
    }

    public Student getStudent(Long id) {
        return studentRepositoryDao.getReferenceById(id);
    }

    public void delStudent(Long id) {
        studentRepositoryDao.deleteById(id);
    }

    public String getStudentName(Long id) {
        return studentRepositoryDao.findNameById(id);
    }

    public int getStudentAge(Long id) {
        return studentRepositoryDao.findAgeById(id);
    }

    public void setMarkById(Long id, int mark) {
        studentRepositoryDao.updateMarkById(id, mark);
    }

    public void setNameById(Long id, String name) {
        studentRepositoryDao.updateNameById(id, name);
    }

    public void setAgeById(Long id, int age) {
        studentRepositoryDao.updateAgeById(id, age);
    }
}
