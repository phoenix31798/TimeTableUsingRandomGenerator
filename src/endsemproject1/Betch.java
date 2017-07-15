package endsemproject1;
import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;
public class Betch {
ArrayList<StudentsGroup> _mygroups=new ArrayList<StudentsGroup>();	
ArrayList<Course> _mycourses=new ArrayList<Course>();
ArrayList<Classroom>_myclassrooms=new ArrayList<Classroom>();
ArrayList<Professor> _myprofessors=new ArrayList<Professor>();
ArrayList<Student>_mystudents=new ArrayList<Student>();
ArrayList<Day>days=new ArrayList<Day>(5);
private int totalseats;
String[] week={"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
public static final int _WORKING_DAYS_PER_WEEK=5;
public Betch(ArrayList<StudentsGroup> _mygroups, ArrayList<Course> _mycourses, ArrayList<Classroom> _myclassrooms,
		ArrayList<Professor> _myprofessors,ArrayList<Student> _mystudents, int totalseats) {
	super();
	this._mygroups = _mygroups;
	this._mycourses = _mycourses;
	this._myclassrooms = _myclassrooms;
	this._myprofessors = _myprofessors;
	this._mystudents=_mystudents;
	this.totalseats = totalseats;
}
public void setdays()
{
	
	ArrayList<Lecture>lectures;
	for(int i=0;i<5;i++)
	{
		lectures=new ArrayList<Lecture>();
	for(int k=0;k<5;k++)
	{
		Lecture l=new Lecture();
		l.set_myid(k+1);
		lectures.add(l);
	}
		Day d=new Day();
		d.set_myname(week[i]);
		d.setLectures(lectures);
		days.add(d);
	}

}
public void maketimetable()
{
	ArrayList<Professor>_mytempprofessors=new ArrayList<Professor>();
	int count1=0;
	int flag1[][]=new int[_myprofessors.size()][200];
	int flag2[][]=new int[_myprofessors.size()][200];
	for(int i=0;i<_myprofessors.size();i++)
	{
	_mytempprofessors.add(_myprofessors.get(i));
	}
	while(true)
	{
	Random rm=new Random();
	if(_mytempprofessors.size()==0)
	{
		break;
	}
	else
	{
		int count2=0;
	int p=rm.nextInt(_mytempprofessors.size());
	int noc=_mytempprofessors.get(p).get_myteachingcourses().size();
	int[] nol=new int[noc];
	int[] nos=new int[noc];
	
	Classroom[][] venues=new Classroom[noc][_myclassrooms.size()];
	for(int i=0;i<noc;i++)
	{
		nol[i]=_mytempprofessors.get(p).get_myteachingcourses().get(i).get_myhoursperweek();
		nos[i]=_mytempprofessors.get(p).get_myteachingcourses().get(i).get_mystudents().size();
		int count=0;
		for(int j=0;j<_myclassrooms.size();j++)
		{
			if(_myclassrooms.get(j).get_mycapacity()>=nos[i])
			{
				venues[i][count]=_myclassrooms.get(j);
				count++;
			}
		}
		while(nol[i]!=0)
		{
		int d,s,v=0;
		String timeslot=null;
	out: while(true)
		{
			 int temp1=rm.nextInt(_mytempprofessors.get(p).days.size());
			 int temp2=rm.nextInt(_mytempprofessors.get(p).days.get(temp1).getLectures().size());
			 int temp3=rm.nextInt(count);
			 for(int j=0;j<_myprofessors.size();j++)
			 {
				 if(_myprofessors.get(j).days.get(temp1).getLectures().get(temp2).typelecture.equals("held"))
				 {
						 if(_myprofessors.get(j).days.get(temp1).getLectures().get(temp2).get_venue().get_myname().equals(venues[i][temp3].get_myname()))
						 {
							 continue out;
						 }
						 else
						 {
							continue;
						 }
					
				 }
			 }
				
				 if(count2!=0)
				 {
				 for(int j=0;j<count2;j++)
				 {
					 if(flag1[count1][j]==temp1 && flag2[count1][j]==temp2)
					 {
						 continue out;
					 }
				 }
				 }
				 for(int j=0;j<_mygroups.size();j++)
				 {
					 for(int k=0;k<_mygroups.get(j).get_mycourses().size();k++)
					 {
						 if(_mytempprofessors.get(p).get_myteachingcourses().get(i).get_myid().equals(_mygroups.get(j).get_mycourses().get(k).get_myid()))
						{
							 if(_mygroups.get(j).get_mystudents().get(0).getDays().get(temp1).getLectures().get(temp2).typelecture.equals("held"))
							 {
								 continue out;
							 }
			  		    }
					 }
				 }
				 flag1[count1][count2]= temp1;
				 flag2[count1][count2]=temp2;
				 count2++;
				 d=temp1;
				 s=temp2;
				 v=temp3;
						switch(s)
						{
						case 0:timeslot="8:00 AM to 9:00 AM";
						break;
						case 1:timeslot="9:00 AM to 10:00 AM";
						break;
						case 2:timeslot="10:00 AM to 11:00 AM";
						break;
						case 3:timeslot="11:00 AM to 12:00 AM";
						break;
						case 4:timeslot="12:00 AM to 1:00 AM";
						break;
						default:
							break;
						}
				 break;
		}
		for(int j=0;j<_myprofessors.size();j++)
		 {
			 if(_mytempprofessors.get(p).get_myname().equals(_myprofessors.get(j).get_myname()))
			 {
				 Professor ph=new Professor();
				 ph=_mytempprofessors.get(p);
				 Course ch=new Course();
				 Classroom cd=new Classroom();
				 ch=_mytempprofessors.get(p).get_myteachingcourses().get(i);
				 cd=venues[i][v];
				_myprofessors.get(j).days.get(d).getLectures().get(s).set_proffesor(ph);
				_myprofessors.get(j).days.get(d).getLectures().get(s).set_course(ch);
				_myprofessors.get(j).days.get(d).getLectures().get(s).set_timeslot(timeslot);
				_myprofessors.get(j).days.get(d).getLectures().get(s).set_venue(cd);
				for(int k=0;k<_myprofessors.get(j).get_myteachingcourses().get(i).get_mystudents().size();k++)
				{
					_myprofessors.get(j).get_myteachingcourses().get(i).get_mystudents().get(k).getDays().get(d).getLectures().get(s).set_proffesor(ph);
					_myprofessors.get(j).get_myteachingcourses().get(i).get_mystudents().get(k).getDays().get(d).getLectures().get(s).set_course(ch);
					_myprofessors.get(j).get_myteachingcourses().get(i).get_mystudents().get(k).getDays().get(d).getLectures().get(s).set_timeslot(timeslot);
					_myprofessors.get(j).get_myteachingcourses().get(i).get_mystudents().get(k).getDays().get(d).getLectures().get(s).set_venue(cd);
				}
			 }
		 }
			nol[i]--;
		}
	}
	_mytempprofessors.remove(_mytempprofessors.get(p));
	
	}
	count1++;
	}
}
public void personaltimetable()
{
	Scanner sc=new Scanner(System.in);
	int noq=sc.nextInt();
	in:for(int j=0;j<=noq;j++)
	{
		String te=sc.nextLine();
		for(int k=0;k<_myprofessors.size();k++)
		{
			if(_myprofessors.get(k).get_myname().equals(te))
			{
				this.professortimetable(te);
				continue in;
			}
		}
		for(int k=0;k<_mystudents.size();k++)
		{
			if(_mystudents.get(k).get_myname().equals(te))
			{
			this.studenttimetable(te);
				continue in;
			}
		}
	}
}
private void professortimetable(String s)
{
	for(int i=0;i<_myprofessors.size();i++)
	{
		if(_myprofessors.get(i).get_myname().equals(s))
		{
			for(int j=0;j<_myprofessors.get(i).getDays().size();j++)
			{
				System.out.println(_myprofessors.get(i).getDays().get(j).get_myname());
				System.out.println();
				for(int k=0;k<_myprofessors.get(i).getDays().get(j).getLectures().size();k++)
				{
					System.out.println("Lecture No: "+_myprofessors.get(i).getDays().get(j).getLectures().get(k).get_myid());
					if(_myprofessors.get(i).getDays().get(j).getLectures().get(k).typelecture.equals("noheld"))
					{
						System.out.println("There is no slot");
					}
					else
					{
						System.out.println("Time Duration: "+_myprofessors.get(i).getDays().get(j).getLectures().get(k).get_timeslot());
						System.out.println("Course: "+_myprofessors.get(i).getDays().get(j).getLectures().get(k).get_course().get_myid());
						System.out.println("Venue: "+_myprofessors.get(i).getDays().get(j).getLectures().get(k).get_venue().get_myname());
					}
				}
				System.out.println();
			}
		}
	}
	System.out.println();
}
private void studenttimetable(String s)
{
	for(int i=0;i<_mystudents.size();i++)
	{
		if(_mystudents.get(i).get_myname().equals(s))
		{
			for(int j=0;j<_mystudents.get(i).getDays().size();j++)
			{
				System.out.println(_mystudents.get(i).getDays().get(j).get_myname());
				System.out.println();
				for(int k=0;k<_mystudents.get(i).getDays().get(j).getLectures().size();k++)
				{
					System.out.println("Lecture No: "+_mystudents.get(i).getDays().get(j).getLectures().get(k).get_myid());
					if(_mystudents.get(i).getDays().get(j).getLectures().get(k).typelecture.equals("noheld"))
					{
						System.out.println("There is no slot");
					}
					else
					{
						System.out.println("Time Duration: "+_mystudents.get(i).getDays().get(j).getLectures().get(k).get_timeslot());
						System.out.println("Course: "+_mystudents.get(i).getDays().get(j).getLectures().get(k).get_course().get_myid());
						System.out.println("Professor: "+_mystudents.get(i).getDays().get(j).getLectures().get(k).get_proffesor().get_myname());
						System.out.println("Venue: "+_mystudents.get(i).getDays().get(j).getLectures().get(k).get_venue().get_myname());
					}
				}
				System.out.println();
			}
		}
	}
	System.out.println();
}
public void printtimetable()
{
	for(int i=0;i<days.size();i++)
	{
		System.out.println();
		System.out.println(week[i]);
		System.out.println();
		for(int j=0;j<days.get(i).getLectures().size();j++)
		{
			int count=0;
			System.out.println("Lecture No: "+days.get(i).getLectures().get(j).get_myid());
			for(int k=0;k<_myprofessors.size();k++)
			{
				if(_myprofessors.get(k).getDays().get(i).getLectures().get(j).typelecture.equals("held"))
				{
					System.out.println("Time Duration: "+_myprofessors.get(k).getDays().get(i).getLectures().get(j).get_timeslot());
			System.out.println("Course: "+_myprofessors.get(k).getDays().get(i).getLectures().get(j).get_course().get_myid());
			System.out.println("Professor: "+_myprofessors.get(k).getDays().get(i).getLectures().get(j).get_proffesor().get_myname());
			System.out.println("Venue: "+_myprofessors.get(k).getDays().get(i).getLectures().get(j).get_venue().get_myname());
				}
				else
				{
					count++;
					continue;
					
				}
			}
			if(count==_myprofessors.size())
			{
				System.out.println("there is no slot");
			}
				}
	}
}
}
