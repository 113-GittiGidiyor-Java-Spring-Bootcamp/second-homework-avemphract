package dev.patika.secondhomework.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/*@JsonTypeInfo(
        use = JsonTypeInfo.Id.DEDUCTION,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        visible = false)
@JsonSubTypes({
        @JsonSubTypes.Type(value = RegularInstructor.class, name = "constantSalary"),//constantSalary Regular
        @JsonSubTypes.Type(value = GuestInstructor.class, name = "hourlySalary")//hourlySalary Guest
})*/
@JsonTypeInfo(use= JsonTypeInfo.Id.DEDUCTION, defaultImpl = Course.class)
@JsonSubTypes({
        @JsonSubTypes.Type(GuestInstructor.class),
        @JsonSubTypes.Type(RegularInstructor.class)
})
@Entity @Inheritance(strategy = InheritanceType.JOINED)
public abstract class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    String name;
    String address;
    long phoneNumber;
    @OneToMany(mappedBy = "instructor")@JsonManagedReference
    List<Course> courses=new ArrayList<>();

    public Instructor(String name, String address, long phoneNumber, List<Course> courses) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.courses=courses;
    }

    public Instructor() {
    }

    //getter setter
    public int getId(){return id;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phoneNumber);
    }
}
