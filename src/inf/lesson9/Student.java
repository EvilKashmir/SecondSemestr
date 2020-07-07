package inf.lesson9;

import java.io.Serializable;
import java.util.*;

public class Student implements Serializable {

    private String name;
    private boolean gender;
    private int age;
    private int group;

    public Student(String name, int group, int age, boolean gender) {
        if (!name.isEmpty() && name.length() < 10 && group > 0 && age > 17 && age < 100) {
            this.name = name;
            this.gender = gender;
            this.age = age;
            this.group = group;
        }
        else throw new InputMismatchException();
    }

    public String getName() { return name; }

    public String isGender() { return gender ? "male" : "female"; }

    public int getAge() { return age; }

    public int getGroup() {
        return group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return gender == student.gender &&
                age == student.age &&
                group == student.group &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gender, age, group);
    }

    @Override
    public String toString() {
        return "(Name: " + getName() +
                ", Group: " + getGroup() +
                ", Age: " + getAge() +
                ", Sex: " + isGender() + ")";
    }
}
