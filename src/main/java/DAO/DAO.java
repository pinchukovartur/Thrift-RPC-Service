package DAO;

import thriftservice.Student;

import java.applet.Applet;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static DAO.Constants.PASSWORD;
import static DAO.Constants.URL;
import static DAO.Constants.USERNAME;


public class DAO extends Applet {

    private Driver driver;
    private Connection connection;

    public DAO() {
        try {
            driver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setStudent(Student student) {
        try {
            PreparedStatement statement = connection.prepareStatement(Constants.INSERT);
            statement.setString(1, student.getName());
            statement.setString(2, student.getSurnamename());
            statement.setInt(3, student.getGroup());
            statement.setInt(4, student.getScore());
            statement.execute();
            statement.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    public void deleteStudentById(int idStudent) {
        try {
            PreparedStatement statement = connection.prepareStatement(Constants.DELETE);
            statement.setInt(1, idStudent);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Student searchStudentById(int idStudent) {
        Student student = new Student();
        try {
            PreparedStatement statement = connection.prepareStatement(Constants.SEARCH);
            statement.setInt(1, idStudent);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                student = new Student();
                student.setStudentid(resultSet.getInt("idstudent"));
                student.setName(resultSet.getString("name"));
                student.setSurnamename(resultSet.getString("surname"));
                student.setScore(resultSet.getInt("score"));
                student.setGroup(resultSet.getInt("brigada"));
            }
            statement.execute();
            statement.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return student;
    }

    public void updateStudentById(Student student) {
        try {
            PreparedStatement statement = connection.prepareStatement(Constants.UPDATE);
            statement.setInt(5, student.getStudentid());
            statement.setString(1, student.getName());
            statement.setString(2, student.getSurnamename());
            statement.setInt(3, student.getGroup());
            statement.setInt(4, student.getScore());
            statement.executeUpdate();
            statement.close();
            statement.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    public List<Student> getAllStudent() {
        List<Student> students = new ArrayList<Student>();
        try {
            PreparedStatement statement = connection.prepareStatement(Constants.SELECT_ALL);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Student student = new Student();
                student.setStudentid(resultSet.getInt("idstudent"));
                student.setName(resultSet.getString("name"));
                student.setSurnamename(resultSet.getString("surname"));
                student.setScore(resultSet.getInt("score"));
                student.setGroup(resultSet.getInt("brigada"));
                students.add(student);
            }
            statement.execute();
            statement.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return students;
    }
}
