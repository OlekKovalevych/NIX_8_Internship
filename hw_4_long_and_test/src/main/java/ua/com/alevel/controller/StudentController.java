package ua.com.alevel.controller;

import ua.com.alevel.entity.Student;
import ua.com.alevel.service.StudentService;

public class StudentController {
    private final StudentService studentService;

    public StudentController(final StudentService studentService) {
        this.studentService = studentService;
    }

    public String create(Student student) {
        return studentService.create(student);
    }

    public Student findById(String id) {
        return studentService.findById(id);
    }

    public Student[] findAll() {
        return studentService.findAll();
    }

    public String update(Student student) {
        return studentService.update(student);
    }


    public String delete(String id) {
        return studentService.delete(id);
    }
}
