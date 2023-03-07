package ua.com.alevel.entity;

public class Student extends BaseEntity {

    private String name;
    private String surname;
    private Course[] courses;

    public Course[] getCourses() {
        return courses;
    }

    public void setCourses(final Course[] courses) {
        this.courses = courses;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(final String surname) {
        this.surname = surname;
    }

    public void setName(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + this.getId() + '\'' +
                ", name='" + this.name + '\'' +
                ", surname='" + this.surname + '\'' +
                ", Courses(" + this.courseArrayToString() + ")" +
                '}';
    }

    private String courseArrayToString() {
        String res = "";
        if (this.courses == null) {
            return null;
        }
        for (final Course cours : this.courses) {
            if (null != cours) {
                res = res + "Name=" + cours.getCourseName() + ";";
            }
        }
        return res;
    }

    public void addCourses(Course course) {
        if (null == courses) {
            courses = new Course[]{course};
        } else {
            for (int i = 0; i < this.courses.length; i++) {
                if (null == this.courses[i]) {
                    this.courses[i] = course;
                    return;
                }
                if (this.courses[i].getId().equals(course.getId())) {
                    return;
                }
            }
            Course[] newArray = new Course[courses.length + 1];
            System.arraycopy(courses, 0, newArray, 1, courses.length);
            newArray[0] = course;
            courses = newArray;
        }
    }

    public void deleteCourse(Course course) {
        if (null != course && this.courses != null) {
            int i;
            for (i = 0; i < this.courses.length; i++) {
                if (this.courses[i].getId().equals(course.getId())) {
                    this.courses[i] = null;
                    break;
                }
            }
            this.courses[i] = this.courses[this.courses.length - 1];
            this.courses[this.courses.length - 1] = null;
            while (this.courses.length > 1 && null == this.courses[this.courses.length - 1]) {
                final Course[] newArray = new Course[this.courses.length - 1];
                System.arraycopy(this.courses, 0, newArray, 0, newArray.length);
            }
        }
    }
}
