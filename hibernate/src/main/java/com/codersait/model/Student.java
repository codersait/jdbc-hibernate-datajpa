package com.codersait.model;

import javax.persistence.*;

@Entity(name = "Student")
@Table(name = "student",uniqueConstraints = { @UniqueConstraint(name = "student_email_unique",columnNames = "email")})
public class Student {
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "student_sequence",sequenceName = "student_id_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "student_sequence")
    private Integer id;

    @Column(name = "first_name",columnDefinition = "TEXT",nullable = false)
    private String firstName;

    @Column(name = "last_name",columnDefinition = "TEXT", nullable = false)
    private String lastName;

    @Column(name = "email", columnDefinition = "TEXT",nullable = false)
    private String email;

    @Column(name = "age",nullable = false)
    private Integer age;

    public Student() {
    }

    public Student(String firstName, String lastName, String email, Integer age) {
        //this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
