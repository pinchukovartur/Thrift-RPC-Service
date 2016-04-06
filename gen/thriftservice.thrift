namespace java tutorial

typedef i32 int
service ThriftService
{
	string setNewStudentInDB(1:string name, 2:string surname, 3:int group, 4:int averageScore),
	string deleteStudentById(1:int idstudent),
	string searchStudentById(1:int idstudent),
	string updateStudentById(1:int idStudent, 2:string name, 3:string surname, 4:int group, 5:int averageScore),
}
