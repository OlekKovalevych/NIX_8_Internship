package ua.com.alevel.entity;

public class Course extends BaseEntity {

    private String courseName;
    private Student[] students;

    public String getCourseName() {
        return this.courseName;
    }

    public void setCourseName(final String courseName) {
        this.courseName = courseName;
    }

    public Student[] getStudents() {
        return this.students;
    }

    public void setStudents(final Student[] students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Course{" +
                "Id='" + this.getId() + '\'' +
                " Course name='" + this.courseName + '\'' +
                ", Students(" + this.studentArrayToString() + ")" +
                '}';
    }

    private String studentArrayToString() {
        String res = " ";
        if (this.students == null) {
            return null;
        }
        for (final Student student : this.students) {
            if (student != null) {
                res = res + "Name=" + student.getName() + ";";
            }
        }
        return res;
    }

    public void addStudent(final Student student) {
        if (null == this.students) {
            this.students = new Student[]{student};
        } else {
            for (int i = 0; i < students.length; i++) {
                if (students[i] == null) {
                    students[i] = student;
                    return;
                }
                if (students[i].getId().equals(student.getId())) {
                    return;
                }
            }
            final Student[] newArray = new Student[this.students.length + 1];
            System.arraycopy(this.students, 0, newArray, 1, this.students.length);
            newArray[0] = student;
            this.students = newArray;
        }
    }

    public void deleteFromStudent(Student student) {
        if (null != student && this.students != null) {
            int i;
            for (i = 0; i < this.students.length; i++) {
                if (this.students[i].getId().equals(student.getId())) {
                    this.students[i] = null;
                    break;
                }
            }
            this.students[i] = this.students[this.students.length - 1];
            this.students[this.students.length - 1] = null;
            while (this.students.length > 1 && null == this.students[this.students.length - 1]) {
                final Course[] newArray = new Course[this.students.length - 1];
                System.arraycopy(this.students, 0, newArray, 0, newArray.length);
            }
        }
    }
}
