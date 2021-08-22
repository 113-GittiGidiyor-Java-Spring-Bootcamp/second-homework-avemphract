package dev.patika.secondhomework.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.persistence.Entity;
import java.util.List;

@Entity
public class GuestInstructor extends Instructor {
    double hourlySalary;

    public GuestInstructor(String name, String address, long phoneNumber, double hourlySalary, List<Course> courses) {
        super(name, address, phoneNumber, courses);
        this.hourlySalary=hourlySalary;
    }

    public GuestInstructor() {
        super();
    }

    //getter setter
    public double getHourlySalary() {
        return hourlySalary;
    }

    public void setHourlySalary(double hourlySalary) {
        this.hourlySalary = hourlySalary;
    }

    //object overriding
    @Override
    public String toString() {
        return "GuestInstructor{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GuestInstructor that = (GuestInstructor) o;
        return Double.compare(that.hourlySalary, hourlySalary) == 0;
    }
}
