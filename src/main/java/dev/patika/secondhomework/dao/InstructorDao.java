package dev.patika.secondhomework.dao;

import dev.patika.secondhomework.model.Instructor;

import java.util.List;

public interface InstructorDao extends BaseDao<Instructor> {
    Instructor enrollCourse(int instructorId, List<Integer> courseList);
}
