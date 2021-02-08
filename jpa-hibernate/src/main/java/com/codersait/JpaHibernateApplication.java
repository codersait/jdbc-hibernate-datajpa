package com.codersait;

import com.codersait.repository.StudentRepository;
import com.codersait.repository.StudentRepositoryImpl;
import com.codersait.service.StudentService;
import com.codersait.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;

@SpringBootApplication
public class JpaHibernateApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaHibernateApplication.class, args);
    }

}
