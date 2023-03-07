package ua.com.alevel.db;

import ua.com.alevel.entity.Course;

import java.util.Objects;
import java.util.UUID;

public class CourseDB {
    private static final CourseDB instance = new CourseDB();
    private static final int START_ARRAY_SIZE = 30;
    private static Course[] courses = new Course[START_ARRAY_SIZE];
    private CourseDB() {

    }

    public static CourseDB getInstance() {
        return instance;
    }

    public String create(final Course course) {
        try {
            course.setId(this.generateId());
            boolean dataRecordingCapability = false;
            for (int i = 0; i < courses.length; i++) {
                if (courses[i] == null) {
                    courses[i] = course;
                    dataRecordingCapability = true;
                    break;
                }
            }
            if (!dataRecordingCapability) {
                this.increasingArray(course);
            }
            return "Course create";
        } catch (Exception e) {
            return "ERROR";
        }
    }

    private void increasingArray(Course course) {
        Course[] newArray = new Course[courses.length + START_ARRAY_SIZE];
        System.arraycopy(courses, 0, newArray, 0, courses.length);
        courses = newArray;
        courses[courses.length] = course;
    }

    public String update(Course course) {
        try {
            Course current = findById(course.getId());
            if (current != null) {
                current.setCourseName(course.getCourseName());
                return "Course was update";
            } else {
                return "we dont have course with this id";
            }
        } catch (Exception e) {
            return "ERROR";
        }
    }

    public Course findById(final String id) {
        try {
            int i;
            for (i = 0; i < courses.length; i++) {
                if (courses[i] == null) {
                    break;
                }
                if (id.equals(courses[i].getId())) {
                    return courses[i];
                }
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public Course[] findAll() {
        try {
            int sizeResultArray = 0;
            for (int i = 0; i < courses.length; i++) {
                if (courses[i] == null) {
                    sizeResultArray = i;
                    break;
                }
            }
            final Course[] newResultArray = new Course[sizeResultArray];
            System.arraycopy(courses, 0, newResultArray, 0, sizeResultArray);
            return newResultArray;
        } catch (Exception e) {
            return null;
        }
    }

    public String delete(String id) {
        try {
            int studentDeletePoint = 0;
            boolean studentExist = false;
            for (int i = 0; i < courses.length; i++) {
                if (null != courses[i] && id.equals(courses[i].getId())) {
                    courses[i] = null;
                    studentDeletePoint = i;
                    studentExist = true;
                }
            }
            if (studentExist) {
                final Course[] newArray = new Course[courses.length];
                System.arraycopy(courses, 0, newArray, 0, studentDeletePoint);
                System.arraycopy(courses, studentDeletePoint + 1, newArray, studentDeletePoint, courses.length - (studentDeletePoint + 1));
                courses = newArray;
                return "Course was delete";
            }
            return "we dont have Course with this id";
        } catch (Exception e) {
            return "ERROR";
        }
    }

    private String generateId() {
        String id;
        do {
            id = this.generateStringUUID();
        } while (this.existId(id));
        return id;
    }

    private boolean existId(String id) {
        for (Course course : courses) {
            if (null == course) break;
            if (id.equals(course.getId())) {
                return true;
            }
        }
        return false;
    }

    private String generateStringUUID() {
        return UUID.randomUUID().toString();
    }
}
