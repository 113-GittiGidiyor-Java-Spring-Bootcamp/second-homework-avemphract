package dev.patika.secondhomework.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Student {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;
    LocalDate birthDate;
    String address;
    String sex;
    @ManyToMany
    List<Course> courses=new ArrayList<>();

    public Student(String name, LocalDate birthDate, String address, String sex, Course... courses) {
        this.name = name;
        this.birthDate = birthDate;
        this.address = address;
        this.sex = sex;
        if (courses!=null)
            Collections.addAll(this.courses,courses);
    }

    public Student() {
    }

    //getter setter
    public int getId(){return id;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String localDate) {
        if (localDate==null)
            return;
        String[] str=localDate.split("-");
        this.birthDate=LocalDate.of(Integer.parseInt(str[0]),
                Month.of(Integer.parseInt(str[1])),
                Integer.parseInt(str[2]));
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    //object overriding
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) && Objects.equals(birthDate, student.birthDate) && Objects.equals(address, student.address) && Objects.equals(sex, student.sex) && Objects.equals(courses, student.courses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthDate);
    }
}
