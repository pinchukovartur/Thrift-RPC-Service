import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.applet.Applet;
import java.sql.*;


public class DAO extends Applet {

    private final String URL = "jdbc:mysql://localhost:3306/StudentWebServiceDB";
    private final String USERNAME = "root";
    private final String PASSWORD = "root";
    private Connection connection = null;
    private PreparedStatement statement = null;
    private Driver driver;

    public DAO() {
    }

    public void setStudent(String name, String surname, int group, int averageScore) {
        try {
            driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            statement = connection.prepareStatement(Constants.INSERT);
            statement.setString(1, name);
            statement.setString(2, surname);
            statement.setInt(3, group);
            statement.setInt(4, averageScore);
            statement.execute();
            connection.close();
            statement.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    public void deleteStudentById(int idstudent) {
        try {
            driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            statement = connection.prepareStatement(Constants.DELETE);
            statement.setInt(1, idstudent);
            statement.executeUpdate();
            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String searchStudentById(int idStudent) {
        String student = null;
        try {
            driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            statement = connection.prepareStatement(Constants.SEARCH);
            statement.setInt(1, idStudent);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String score = String.valueOf(resultSet.getInt("score"));
                String group = String.valueOf(resultSet.getInt("brigada"));
                student = idStudent + "    " + name + "    " + surname + "    " + score + "    " + group;
            }
            statement.execute();
            connection.close();
            statement.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return student;
    }

    public void updateStudentById(int idstudent, String name, String surname, int group, int averageScore) {
        try {
            driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            statement = connection.prepareStatement(Constants.UPDATE);
            statement.setInt(5, idstudent);
            statement.setString(1, name);
            statement.setString(2, surname);
            statement.setInt(3, group);
            statement.setInt(4, averageScore);
            statement.executeUpdate();
            connection.close();
            statement.close();
            statement.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

}
