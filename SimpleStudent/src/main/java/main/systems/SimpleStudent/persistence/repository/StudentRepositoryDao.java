package main.systems.SimpleStudent.persistence.repository;

import main.systems.SimpleStudent.persistence.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepositoryDao extends JpaRepository<Student, Long> {
//    @Query(value = "select s.id from Student s where s.id = :id")
//    Student findStudentById(Long id);

    @Query(nativeQuery = true, value = "select name from students where id = :id")
    String findNameById(Long id);

    @Query(nativeQuery = true, value = "select age from students where id = :id")
    int findAgeById(Long id);

    @Query(nativeQuery = true, value = "select mark from students where id = :id")
    int findMarkById(Long id);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "update students set mark = :mark where id = :id")
    void updateMarkById(Long id, int mark);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "update students set name = :name where id = :id")
    void updateNameById(Long id, String name);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "update students set age = :age where id = :id")
    void updateAgeById(Long id, int age);
}
