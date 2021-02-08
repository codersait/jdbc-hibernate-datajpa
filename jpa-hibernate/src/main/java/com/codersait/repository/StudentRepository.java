package com.codersait.repository;

import com.codersait.model.Student;

import java.util.List;

public interface StudentRepository {

    public List<Student> findAll();
    public void save(Student student);
    public void delete(Integer id);
    public void update (Integer id, Student student);
}
