package ua.com.alevel;

import ua.com.alevel.controller.CourseController;
import ua.com.alevel.controller.StudentController;
import ua.com.alevel.dao.CourseDao;
import ua.com.alevel.dao.StudentDao;
import ua.com.alevel.entity.Course;
import ua.com.alevel.entity.Student;
import ua.com.alevel.service.CourseService;
import ua.com.alevel.service.StudentService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.apache.xalan.xsltc.compiler.util.Util.println;

public class ProgramRun {

    public void run() {
        StudentController studentController = new StudentController(new StudentService(new StudentDao()));
        CourseController courseController = new CourseController(new CourseService(new CourseDao()));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        println("select your option");
        String position;
        try {
            this.runNavigation();
            while (null != (position = reader.readLine())) {
                this.crud(position, reader, studentController, courseController);
                position = reader.readLine();
                if (position.equals("0")) {
                    System.exit(0);
                }
                this.crud(position, reader, studentController, courseController);
            }
        } catch (IOException e) {
            println("problem: = " + e.getMessage());
        }
    }

    private void runNavigation() {
        println("");
        println("if you want create Student, please enter 1");
        println("if you want update Student, please enter 2");
        println("if you want delete Student, please enter 3");
        println("if you want findById Student, please enter 4");
        println("if you want findAll Student, please enter 5");
        println("if you want create Course, please enter 6");
        println("if you want update Course, please enter 7");
        println("if you want delete Course, please enter 8");
        println("if you want findById Course, please enter 9");
        println("if you want findAll Course, please enter 10");
        println("if you want add Student to Course, please enter 11");
        println("if you want exit, please enter 0");
        println("");
    }

    private void crud(String position, BufferedReader reader, StudentController studentController, CourseController courseController) {
        switch (position) {
            case "1":
                this.createStudent(reader, studentController);
                break;
            case "2":
                this.updateStudent(reader, studentController);
                break;
            case "3":
                this.deleteStudent(reader, studentController);
                break;
            case "4":
                this.findByIdStudent(reader, studentController);
                break;
            case "5":
                this.findAllStudent(reader, studentController);
                break;
            case "6":
                this.createCourse(reader, courseController);
                break;
            case "7":
                this.updateCourse(reader, courseController);
                break;
            case "8":
                this.deleteCourse(reader, courseController);
                break;
            case "9":
                this.findByIdCourse(reader, courseController);
                break;
            case "10":
                this.findAllCourse(reader, courseController);
                break;
            case "11":
                this.addStudentToCourse(reader, courseController, studentController);
                break;
        }
        this.runNavigation();
    }

    private void addStudentToCourse(BufferedReader reader, CourseController courseController, StudentController studentController) {
        try {
            Student student = studentController.findById(getString(reader, "Enter student id"));
            Course course = courseController.findById(getString(reader, "Enter course id"));
            if (null == student || null == course) {
                println("Error");
                return;
            }
            student.addCourses(course);
            course.addStudent(student);
        } catch (Exception e) {
            println("ERROR");
        }
    }

    private void createStudent(BufferedReader reader, StudentController controller) {
        println("StudentController.create");
        try {
            Student student = new Student();
            student.setName(getString(reader, "Please, enter  Name:"));
            student.setSurname(getString(reader, "Please, enter  Surname:"));
            println(controller.create(student));
        } catch (IOException e) {
            println("problem: = " + e.getMessage());
        }
    }

    private void createCourse(BufferedReader reader, CourseController controller) {
        println("CourseController.create");
        try {
            Course course = new Course();
            course.setCourseName(getString(reader, "Please, enter  Course Name:"));
            println(controller.create(course));
        } catch (IOException e) {
            println("problem: = " + e.getMessage());
        }
    }

    private void updateStudent(BufferedReader reader, StudentController controller) {
        println("StudentController.update");
        try {
            Student student = new Student();
            student.setId(getString(reader, "Please, enter id"));
            student.setName(getString(reader, "Please, enter your Name:"));
            student.setSurname(getString(reader, "Please, enter your Surname:"));
            println(controller.update(student));
        } catch (IOException e) {
            println("problem: = " + e.getMessage());
        }
    }

    private void updateCourse(BufferedReader reader, CourseController controller) {
        println("CourseController.update");
        try {
            Course course = new Course();
            course.setId(getString(reader, "Please, enter id"));
            course.setCourseName(getString(reader, "Please, enter  Course Name:"));
            println(controller.update(course));
        } catch (IOException e) {
            println("problem: = " + e.getMessage());
        }
    }

    private void deleteStudent(BufferedReader reader, StudentController controller) {
        try {
            println(controller.delete(getString(reader, "Please, enter id")));
        } catch (IOException e) {
            println("problem: = " + e.getMessage());
        }
    }

    private void deleteCourse(BufferedReader reader, CourseController controller) {
        try {
            println(controller.delete(getString(reader, "Please, enter id")));
        } catch (IOException e) {
            println("problem: = " + e.getMessage());
        }
    }

    private void findByIdStudent(BufferedReader reader, StudentController controller) {
        println("StudentController.findById");
        try {
            Student student = controller.findById(getString(reader, "Please, enter id"));
            if (null == student) {
                println("student = not found");
            } else {
                println("student = " + student);
            }
        } catch (IOException e) {
            println("problem: = " + e.getMessage());
        }
    }

    private void findByIdCourse(BufferedReader reader, CourseController controller) {
        println("CourseController.findById");
        try {
            Course course = controller.findById(getString(reader, "Please, enter id"));
            if (null == course) {
                println("course = not found");
            } else {
                println("course = " + course);
            }
        } catch (IOException e) {
            println("problem: = " + e.getMessage());
        }
    }


    private void findAllStudent(BufferedReader reader, StudentController controller) {
        println("StudentController.findAll");
        Student[] students = controller.findAll();
        if (null != students && students.length != 0) {
            for (Student student : students) {
                println("student = " + student.toString());
            }
        } else {
            println("student empty");
        }
    }

    private void findAllCourse(BufferedReader reader, CourseController controller) {
        println("CourseController.findAll");
        Course[] courses = controller.findAll();
        if (null != courses && 0 != courses.length) {
            for (Course course : courses) {
                println("course = " + course.toString());
            }
        } else {
            println("course empty");
        }
    }

    private String getString(BufferedReader reader, String messageLine) throws IOException {
        println(messageLine);
        return reader.readLine();
    }
}
