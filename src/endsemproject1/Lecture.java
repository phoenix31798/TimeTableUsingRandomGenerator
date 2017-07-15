package endsemproject1;

public class Lecture {
	private int _myid;
public int get_myid() {
		return _myid;
	}
	public void set_myid(int _myid) {
		this._myid = _myid;
	}
	String typelecture="noheld";
private Course _course=new Course();
private Professor _proffesor=new Professor();
private Classroom _venue=new Classroom();
private String _timeslot;
public String get_timeslot() {
	return _timeslot;
}
public void set_timeslot(String _timeslot) {
	this._timeslot = _timeslot;
	typelecture="held";
}
public Course get_course() {
	return _course;
}
public void set_course(Course _course) {
	this._course = _course;
}
public Professor get_proffesor() {
	return _proffesor;
}
public void set_proffesor(Professor _proffesor) {
	this._proffesor = _proffesor;
}
public Classroom get_venue() {
	return _venue;
}
public void set_venue(Classroom _venue) {
	this._venue = _venue;
}

}

