package com.codersait.repository;

import com.codersait.model.Student;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class StudentRepositoryImpl implements StudentRepository{

    private final EntityManager entityManager;

    public StudentRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<Student> findAll() {
        Session session = entityManager.unwrap(Session.class);
        List<Student> students = session.createQuery("from Student ", Student.class).getResultList();

        return students;
    }

    @Override
    public void save(Student student) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(student);
    }

    @Override
    public void delete(Integer id) {
        Session session = entityManager.unwrap(Session.class);
        Student student1 = session.get(Student.class, id);
        session.delete(student1);

    }

    @Override
    public void update(Integer id, Student student) {
        Session session = entityManager.unwrap(Session.class);
        Student student1 = session.get(Student.class, id);
        student1.setFirstName(student.getFirstName());
        student1.setLastName(student.getLastName());
        student1.setEmail(student.getEmail());
        student1.setAge(student.getAge());

        session.saveOrUpdate(student1);
    }
}
