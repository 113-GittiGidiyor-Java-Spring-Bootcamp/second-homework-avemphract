package dev.patika.secondhomework.model;

import javax.persistence.Entity;
import java.util.List;

@Entity
public class RegularInstructor extends Instructor {
    double constantSalary;

    public RegularInstructor(String name, String address, long phoneNumber, double constantSalary, List<Course> courses) {
        super(name, address, phoneNumber, courses);
        this.constantSalary = constantSalary;
    }

    public RegularInstructor() {
        super();
    }

    //getter setter
    public double getConstantSalary() {
        return constantSalary;
    }

    public void setConstantSalary(double constantSalary) {
        this.constantSalary = constantSalary;
    }

    //object overriding
    @Override
    public String toString() {
        return "PermanentInstructor{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegularInstructor that = (RegularInstructor) o;
        return Double.compare(that.constantSalary, constantSalary) == 0;
    }

}
