package dev.patika.secondhomework.dao;

import dev.patika.secondhomework.model.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao extends BaseDao<Student> {
    Student enrollCourse(int studentId, List<Integer> coursesId);
}
