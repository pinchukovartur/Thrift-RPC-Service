import org.apache.thrift.TException;

public class ThriftHandler implements ThriftService.Iface {

    private DAO dao;

    public ThriftHandler(){dao = new DAO();}

    @Override
    public String setNewStudentInDB(String name, String surname, int group, int averageScore) throws TException {
        dao.setStudent(name,surname,group,averageScore);
        return "Студент успешно добавлен!";
    }

    @Override
    public String deleteStudentById(int idstudent) throws TException {
        dao.deleteStudentById(idstudent);
        return "Студент успешно удален";
    }

    @Override
    public String searchStudentById(int idstudent) throws TException {
        if(dao.searchStudentById(idstudent)!=null){
        return dao.searchStudentById(idstudent);}
        else return"sorry";
    }

    @Override
    public String updateStudentById(int idStudent, String name, String surname, int group, int averageScore) throws TException {
        dao.updateStudentById(idStudent,name,surname,group,averageScore);
        return "Студент успешно обновлен";
    }
}