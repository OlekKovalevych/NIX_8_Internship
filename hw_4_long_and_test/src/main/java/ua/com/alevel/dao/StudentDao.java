package ua.com.alevel.dao;

import ua.com.alevel.db.CourseDB;
import ua.com.alevel.db.StudentDB;
import ua.com.alevel.entity.Course;
import ua.com.alevel.entity.Student;

public class StudentDao {
    private final StudentDB db;
    private final CourseDB courseDao;

    public StudentDao() {
        this.db = StudentDB.getInstance();
        this.courseDao=CourseDB.getInstance();
    }

    public String create(Student student) {
        return db.create(student);
    }

    public Student findById(String id) {
        return db.findById(id);
    }

    public Student[] findAll() {
        return db.findAll();
    }

    public String update(Student student) {
        return db.update(student);
    }



    public String delete(String id) {
        try {
            Student student = db.findById(id);

            if (null != student) {
                if (student.getCourses() != null) {
                    Course[] courses = student.getCourses();
                    for (int i = 0; i < student.getCourses().length; i++) {
                        courseDao.findById(courses[i].getId()).deleteFromStudent(student);
                    }
                }
            }
           return db.delete(id);
        } catch (Exception e) {
            return "Error";
        }
    }
}
