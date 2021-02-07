package com.codersait.repository;

import com.codersait.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository {
    public List<Student> findAll();
    public Student findById(Integer id);
    public void save(Student student);
    public void delete(Student student);
    public void update (Integer id, Student student);

}
