package ua.com.alevel.dao;

import ua.com.alevel.db.CourseDB;
import ua.com.alevel.db.StudentDB;
import ua.com.alevel.entity.Course;
import ua.com.alevel.entity.Student;

public class CourseDao {
    private final CourseDB db;
    private final StudentDB studentDao;

    public CourseDao() {
        this.db = CourseDB.getInstance();
        this.studentDao = StudentDB.getInstance();
    }

    public String create(Course course) {
        return db.create(course);
    }

    public Course findById(String id) {
        return db.findById(id);
    }

    public Course[] findAll() {
        return db.findAll();
    }

    public String update(Course course) {
        return db.update(course);
    }

    public String delete(String id) {
        try {
            Course course = db.findById(id);
            if (null != course) {
                if (course.getStudents() != null) {
                    Student[] students = course.getStudents();
                    for (int i = 0; i < course.getStudents().length; i++) {
                        studentDao.findById(students[i].getId()).deleteCourse(course);
                    }
                }
            }
            return db.delete(id);
        } catch (Exception e) {
            return "Error";
        }
    }
}
