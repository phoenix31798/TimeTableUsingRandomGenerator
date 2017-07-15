package endsemproject1;

import java.util.ArrayList;

public class Day {
	private String _myname;
public String get_myname() {
		return _myname;
	}
	public void set_myname(String _myname) {
		this._myname = _myname;
	}
private ArrayList<Lecture>lectures=new ArrayList<Lecture>(_MAX_LECTURES_PER_DAY);
public ArrayList<Lecture> getLectures() {
	return lectures;
}
public void setLectures(ArrayList<Lecture> lectures) {
	this.lectures = lectures;
}
public static final int _MAX_LECTURES_PER_DAY=5;
}
