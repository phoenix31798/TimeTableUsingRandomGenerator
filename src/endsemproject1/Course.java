package endsemproject1;

import java.util.ArrayList;

public class Course {
private String _myid;
private String _myname;
private Classroomtype _myvenuetype;
private Professor _myprofessor;
private int _myhoursperweek;
private ArrayList<Student>_mystudents=new ArrayList<Student>();
public ArrayList<Student> get_mystudents() {
	return _mystudents;
}
public void set_mystudents(Student _mystudent) {
	this._mystudents.add(_mystudent);
}
public String get_myid() {
	return _myid;
}
public void set_myid(String _myid) {
	this._myid = _myid;
}
public String get_myname() {
	return _myname;
}
public void set_myname(String _myname) {
	this._myname = _myname;
}
public Classroomtype get_myvenuetype() {
	return _myvenuetype;
}
public void set_myvenuetype(Classroomtype _myvenue) {
	this._myvenuetype = _myvenue;
}
public Professor get_myprofessor() {
	return _myprofessor;
}
public void set_myprofessor(Professor _myprofessor) {
	this._myprofessor = _myprofessor;
}
public int get_myhoursperweek() {
	return _myhoursperweek;
}
public void set_myhoursperweek(int _myhoursperweek) {
	this._myhoursperweek = _myhoursperweek;
}
}
