package com.codersait.repository;

import com.codersait.exeptions.CustomException;
import com.codersait.model.Student;
import com.codersait.utils.DbHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryImpl implements StudentRepository {
    @Override
    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        try (Connection connection = DbHelper.getConnection()) {
            var statement = connection.createStatement();
            var resultSet = statement.executeQuery("SELECT id,first_name,last_name,email,age FROM student");
            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setFirstName(resultSet.getString("first_name"));
                student.setLastName(resultSet.getString("last_name"));
                student.setEmail(resultSet.getString("email"));
                student.setAge(resultSet.getInt("age"));
                students.add(student);
            }

        } catch (SQLException exception) {
            DbHelper.showErrorMessage(exception);
        }
        return students;
    }

    @Override
    public Student findById(Integer id) {
        Student student = new Student();
        try(Connection connection = DbHelper.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id,first_name,last_name,email,age FROM student WHERE ID=?");
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {
                student.setId(id);
                student.setFirstName(resultSet.getString("first_name"));
                student.setLastName(resultSet.getString("last_name"));
                student.setEmail(resultSet.getString("email"));
                student.setAge(resultSet.getInt("age"));
            }
        } catch (SQLException exception) {
            DbHelper.showErrorMessage(exception);
        }
        return student;
    }

    @Override
    public void save(Student student) {
        try (Connection connection = DbHelper.getConnection()) {
            var statement = connection.prepareStatement("INSERT INTO student(first_name,last_name,email,age) values (?,?,?,?)");

            statement.setString(1,student.getFirstName());
            statement.setString(2,student.getLastName());
            statement.setString(3,student.getEmail());
            statement.setInt(4,student.getAge());

            statement.executeUpdate();

        } catch (SQLException exception) {
            DbHelper.showErrorMessage(exception);
        }

    }

    @Override
    public void delete(Student student) {
        try (Connection connection = DbHelper.getConnection()) {
            var statement = connection.prepareStatement(" DELETE FROM student where id = ?");
            statement.setInt(1,student.getId());
            statement.executeUpdate();

        } catch (SQLException exception) {
            DbHelper.showErrorMessage(exception);
        }
    }

    @Override
    public void update(Integer id,Student student) {
        try (Connection connection = DbHelper.getConnection()) {
            var statement = connection.prepareStatement(" UPDATE student SET first_name = ?,last_name = ?, email = ?, age = ? WHERE id = ?");
            statement.setString(1,student.getFirstName());
            statement.setString(2,student.getLastName());
            statement.setString(3,student.getEmail());
            statement.setInt(4,student.getAge());
            statement.setInt(5,id);
            statement.executeUpdate();

        } catch (SQLException exception) {
            DbHelper.showErrorMessage(exception);
        }
    }
}
