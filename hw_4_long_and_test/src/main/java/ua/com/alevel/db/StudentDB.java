package ua.com.alevel.db;

import ua.com.alevel.entity.Student;

import java.util.UUID;

public class StudentDB {

    private static final StudentDB instance = new StudentDB();
    private static final int START_ARRAY_SIZE = 30;
    private static Student[] students = new Student[START_ARRAY_SIZE];
    private StudentDB() {
    }

    public static StudentDB getInstance() {
        return instance;
    }

    public String create(final Student student) {
        try {
            student.setId(this.generateId());
            boolean dataRecordingCapability = false;
            for (int i = 0; i < students.length; i++) {
                if (students[i] == null) {
                    students[i] = student;
                    dataRecordingCapability = true;
                    break;
                }
            }
            if (!dataRecordingCapability) {
                this.increasingArray(student);
            }
            return "Student create";
        } catch (Exception e) {
            return "ERROR";
        }
    }

    private void increasingArray(Student studentUITM) {
        Student[] newArray = new Student[students.length + START_ARRAY_SIZE];
        System.arraycopy(students, 0, newArray, 0, students.length);
        students = newArray;
        students[students.length] = studentUITM;
    }

    public String update(Student student) {
        try {
            Student current = this.findById(student.getId());
            if (current != null) {
                current.setName(student.getName());
                current.setSurname(student.getSurname());
                return "Student was update";
            } else {
                return "we dont have student with this id";
            }
        } catch (Exception e) {
            return "ERROR";
        }
    }

    public Student findById(final String id) {
        try {
            int i;
            for (i = 0; i < students.length; i++) {
                if (students[i] == null) {
                    break;
                }
                if (id.equals(students[i].getId())) {
                    return students[i];
                }
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public Student[] findAll() {
        try {
            int sizeResultArray = 0;
            for (int i = 0; i < students.length; i++) {
                if (students[i] == null) {
                    sizeResultArray = i;
                    break;
                }
            }
            final Student[] newResultArray = new Student[sizeResultArray];
            System.arraycopy(students, 0, newResultArray, 0, sizeResultArray);
            return newResultArray;
        } catch (Exception e) {
            return null;
        }
    }

    public String delete(String id) {
        try {
            int studentDeletePoint = 0;
            boolean studentExist = false;
            for (int i = 0; i < students.length; i++) {
                if (null != students[i] && id.equals(students[i].getId())) {
                    students[i] = null;
                    studentDeletePoint = i;
                    studentExist = true;
                }
            }
            if (studentExist) {
                final Student[] newArray = new Student[students.length];
                System.arraycopy(students, 0, newArray, 0, studentDeletePoint);
                System.arraycopy(students, studentDeletePoint + 1, newArray, studentDeletePoint, students.length - (studentDeletePoint + 1));
                students = newArray;
                return "Student was delete";
            }
            return "we dont have student with this id";
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
        for (Student student : students) {
            if (null == student) break;
            if (id.equals(student.getId())) {
                return true;
            }
        }
        return false;
    }

    private String generateStringUUID() {
        return UUID.randomUUID().toString();
    }
}
