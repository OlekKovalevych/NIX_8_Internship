package ua.com.alevel.service;

import ua.com.alevel.dao.CourseDao;
import ua.com.alevel.dao.StudentDao;
import ua.com.alevel.entity.Course;
import ua.com.alevel.entity.Student;

public class CourseService {

    private final CourseDao courseDao;

    public CourseService(final CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    public String create(Course course) {
        return courseDao.create(course);
    }

    public Course findById(String id) {
        return courseDao.findById(id);
    }

    public Course[] findAll() {return courseDao.findAll();}

    public String update(Course course) {
        return courseDao.update(course);
    }

    public String  delete(String id) {
        return courseDao.delete(id);
    }
}
