package ua.com.alevel.entity;

public class Worker {

    private String id;
    private String firstName;
    private String lastName;
    private String patronymic;

    public String getPatronymic() {
        return this.patronymic;
    }

    public void setPatronymic(final String patronymic) {
        this.patronymic = patronymic;
    }

    public final String getId() {
        return this.id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "id='" + id + '\'' +
                ",First Name='" + firstName + '\'' +
                ", Last Name' " + lastName + '\'' +
                ", Patronymic='" + patronymic + '\'' +
                '}';
    }
}
