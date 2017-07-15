package endsemproject1;
import java.util.ArrayList;
public class Student {
private String _myname;
private int _myid;
ArrayList<Day>days=new ArrayList<Day>();
private ArrayList<Course>_mylearningcourses=new ArrayList<Course>();
public static final int _myworkingdays=5;
public ArrayList<Day> getDays() {
	return days;
}
public void setDays(ArrayList<Day> days) {
	this.days = days;
}
public void set_mylearningcourses(Course s) {
_mylearningcourses.add(s);
}
public ArrayList<Course> get_mylearningcourses() {
	return _mylearningcourses;
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

}
