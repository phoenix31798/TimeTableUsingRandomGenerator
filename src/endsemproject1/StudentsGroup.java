package endsemproject1;

import java.util.ArrayList;
public class StudentsGroup {
private int _myid;
private String _myname;
private ArrayList<Student> _mystudents=new ArrayList<Student>();
public void set_mystudents(ArrayList<Student> _mystudents) {
	this._mystudents = _mystudents;
}
private ArrayList<Course> _mycourses=new ArrayList<Course>();
public ArrayList<Student> get_mystudents() {
	return _mystudents;
}
public void set_mystudents(Student _mystudents) {
	this._mystudents.add(_mystudents);
}
public ArrayList<Course> get_mycourses() {
	return _mycourses;
}
public void set_mycourses(ArrayList<Course> _mycourses) {
	this._mycourses = _mycourses;
}
public int get_myid() {
	return _myid;
}
public void set_myid(int _myid) {
	this._myid = _myid;
}
public String get_myname() {
	return _myname;
}
public void set_myname(String _myname) {
	this._myname = _myname;
}
}
