package com.codersait.service;

import com.codersait.exeptions.CustomException;
import com.codersait.model.Student;
import com.codersait.repository.StudentRepository;

import java.util.List;

public class StudentServiceImpl implements StudentService{
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student getById(Integer id) {
        return studentRepository.findById(id);
    }

    @Override
    public void update(Integer id,Student student) {
        studentRepository.update(id,student);

    }

    @Override
    public void add(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void delete(Integer id) {
        Student student = studentRepository.findById(id);
        studentRepository.delete(student);
    }
}
