namespace java tutorial

typedef i32 int
service thriftservice.ThriftService
{
	void setNewStudentInDB(1:thriftservice.Student student),
	void deleteStudentById(1:int idstudent),
	thriftservice.Student searchStudentById(1:int idstudent),
	void updateStudentById(1:thriftservice.Student student),
}
struct thriftservice.Student {
  1: i32 studentid,
  2: string name,
  3: string surnamename,
  4: i32 group,
  5: i32 score,
}
