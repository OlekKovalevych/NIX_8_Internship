package ua.com.alevel.controller;

import ua.com.alevel.entity.Course;
import ua.com.alevel.service.CourseService;

public class CourseController {

    private final CourseService courseService;

    public CourseController(final CourseService courseService) {
        this.courseService = courseService;
    }

    public String create(Course course) {
        return courseService.create(course);
    }

    public Course findById(String id) {
        return courseService.findById(id);
    }

    public Course[] findAll() {
        return courseService.findAll();
    }

    public String update(Course course) {
        return courseService.update(course);
    }

    public String delete(String id) {
        return courseService.delete(id);
    }
}
