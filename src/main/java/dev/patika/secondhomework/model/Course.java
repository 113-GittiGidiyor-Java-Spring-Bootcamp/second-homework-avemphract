package dev.patika.secondhomework.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Course {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String courseName;
    String courseCode;
    double credit;
    @ManyToOne
    Instructor instructor;

    public Course(String courseName, String courseCode, double credit, Instructor instructor) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.credit = credit;
        this.instructor = instructor;
    }

    public Course() {
    }

    //getter setter
    public int getId(){return id;}

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    //object overriding
    @Override
    public String toString() {
        return "Course{" +
                "courseName='" + courseName + '\'' +
                ", courseCode='" + courseCode + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Double.compare(course.credit, credit) == 0 && Objects.equals(courseName, course.courseName) && Objects.equals(courseCode, course.courseCode) && Objects.equals(instructor, course.instructor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseName, courseCode);
    }
}
