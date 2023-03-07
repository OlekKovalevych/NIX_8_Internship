package ua.com.alevel;

public class User {

    private String name;
    private int age;

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(final int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name=" + name + '\'' +
                ",age=" + age +
                '}';
    }
}
