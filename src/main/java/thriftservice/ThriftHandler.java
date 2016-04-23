package thriftservice;

import DAO.DAO;
import org.apache.thrift.TException;


public class ThriftHandler implements ThriftService.Iface {

    private DAO dao;

    public ThriftHandler(){
        dao = new DAO();
    }

    @Override
    public void setNewStudentInDB(Student student) throws TException {
        dao.setStudent(student);
    }

    @Override
    public void deleteStudentById(int idstudent) throws TException {
        dao.deleteStudentById(idstudent);
    }

    @Override
    public Student searchStudentById(int idstudent) throws TException {
        Student student = new Student();
        if(dao.searchStudentById(idstudent)!=null){
        return dao.searchStudentById(idstudent);}
        else return student;
    }

    @Override
    public void updateStudentById(Student student) throws TException {
        dao.updateStudentById(student);
    }

}