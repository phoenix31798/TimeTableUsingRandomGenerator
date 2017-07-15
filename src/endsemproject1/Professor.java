package endsemproject1;

import java.util.ArrayList;

public class Professor {
private String _myname;
private int _myid;
ArrayList<Course> _myteachingcourses=new ArrayList<Course>(_myworkingdays);
public static final int _myworkingdays=5;
public static final int _MAX_LECTURES_PER_DAY=5;
ArrayList<Day>days=new ArrayList<Day>();
public ArrayList<Day> getDays() {
	return days;
}
public void setDays(ArrayList<Day> days) {
	this.days = days;
}
public String get_myname() {
	return _myname;
}
public void set_myname(String _myname) {
	this._myname = _myname;
}
public int get_myid() {
	return _myid;
}
public void set_myid(int _myid) {
	this._myid = _myid;
}

public ArrayList<Course> get_myteachingcourses() {
	return _myteachingcourses;
}
public void set_myteachingcourses(Course _myteachingcourses) {
	this._myteachingcourses.add(_myteachingcourses);
}
}
