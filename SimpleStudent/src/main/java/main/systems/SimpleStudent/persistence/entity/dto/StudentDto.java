package main.systems.SimpleStudent.persistence.entity.dto;

import main.systems.SimpleStudent.persistence.entity.Student;

import javax.persistence.Column;

public class StudentDto {
    private Long id;
    private String name;
    private int mark;
    private int age;

    public StudentDto() {
    }

    public StudentDto(Student student) {
        this.id = student.getId();
        this.name = student.getName();
        this.mark = student.getMark();
        this.age = student.getAge();
    }

    public StudentDto(Long id, String name, int mark, int age) {
        this.id = id;
        this.name = name;
        this.mark = mark;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
