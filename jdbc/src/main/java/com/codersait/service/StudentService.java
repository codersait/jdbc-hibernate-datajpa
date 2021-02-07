package com.codersait.service;

import com.codersait.model.Student;

import java.util.List;

public interface StudentService {
    public List<Student> getAll();
    public Student getById(Integer id);
    public void update(Integer id,Student student);
    public void add(Student student);
    public void delete(Integer id);
}
