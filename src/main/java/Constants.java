public class Constants {

    static final String INSERT= "INSERT INTO student(name, surname, score, brigada) VALUES (?,?,?,?)";

    static final String DELETE = "DELETE FROM student WHERE idstudent=?";

    static final String SEARCH = "SELECT distinct student.idstudent, student.name, student.surname, student.score," +
            " student.brigada FROM student WHERE idstudent = ?;";

    static final String UPDATE = "UPDATE student SET name=?, surname=?, score=?, brigada=? WHERE idstudent=?";
}
