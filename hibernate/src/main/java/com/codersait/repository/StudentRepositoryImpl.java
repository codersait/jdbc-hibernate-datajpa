package com.codersait.repository;

import com.codersait.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class StudentRepositoryImpl implements StudentRepository{
    SessionFactory sessionFactory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Student.class)
            .buildSessionFactory();

    @Override
    public List<Student> findAll() {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            List<Student> students = session.createQuery("FROM Student ").getResultList();
            session.getTransaction().commit();
            return students;
        }
        finally {
            session.close();
        }
    }


    @Override
    public void save(Student student) {

        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();

            session.save(student);

            session.getTransaction().commit();

        }
        finally {
            session.close();
        }

    }

    @Override
    public void delete(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();

            Student deleted = session.get(Student.class,id);
            session.delete(deleted);
            session.getTransaction().commit();

        }
        finally {
            session.close();
        }

    }

    @Override
    public void update(Integer id, Student student) {

        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();

            Student update = session.get(Student.class,id);
            update.setFirstName(student.getFirstName());
            update.setLastName(student.getLastName());
            update.setEmail(student.getEmail());
            update.setAge(student.getAge());
            session.save(update);
            session.getTransaction().commit();

        }
        finally {
            session.close();
        }

    }
}
