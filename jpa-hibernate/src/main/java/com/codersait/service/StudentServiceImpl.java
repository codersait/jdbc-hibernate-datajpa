package com.codersait.service;

import com.codersait.model.Student;
import com.codersait.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService{
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    @Transactional
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    @Transactional
    public void update(Integer id, Student student) {
        studentRepository.update(id, student);
    }

    @Override
    @Transactional
    public void add(Student student) {
        studentRepository.save(student);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        studentRepository.delete(id);
    }
}
