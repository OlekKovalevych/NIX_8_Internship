package ua.com.alevel.service;

import ua.com.alevel.dao.StudentDao;
import ua.com.alevel.entity.Student;

public class StudentService {

    private final StudentDao studentDao;

    public StudentService(final StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public String create(Student student) {
        return studentDao.create(student);
    }

    public Student findById(String id) {
        return studentDao.findById(id);
    }

    public Student[] findAll() {
        return studentDao.findAll();
    }

    public String update(Student student) {
        return studentDao.update(student);
    }

    public String  delete(String id) {
        return studentDao.delete(id);
    }
}

