package endsemproject1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Tester {

	public static void main(String[] args) throws FileNotFoundException {
Scanner sc1=new Scanner(new File("subject.txt"));
Scanner sc2=new Scanner(new File("classroom.txt"));
Scanner sc3=new Scanner(new File("student.txt"));
ArrayList<Course>courses=new ArrayList<Course>();
ArrayList<Professor>professors=new ArrayList<Professor>();
ArrayList<Classroom> classrooms=new ArrayList<Classroom>();
ArrayList<Student>students=new ArrayList<Student>();
ArrayList<StudentsGroup>studentsgroups=new ArrayList<StudentsGroup>();

int nop=0;
while(sc1.hasNextLine())
{
	Course c=new Course();
	
	String[] splits=sc1.nextLine().split(",");
	c.set_myid(splits[0]);
	c.set_myname(splits[1]);
	c.set_myhoursperweek(Integer.parseInt(splits[4]));
	if(splits[2].equals("Lec"))
	{
	Classroomtype Lec=new Classroomtype("Lec","bench");
	c.set_myvenuetype(Lec);
	}
	else if(splits[2].equals("Lab"))
	{
		Classroomtype Lab=new Classroomtype("Lab","computer");
		c.set_myvenuetype(Lab);
	}
	int flag=0;
	for(int i=0;i<professors.size();i++)
	{
		if(professors.get(i).get_myname().equals(splits[3]))
		{
			c.set_myprofessor(professors.get(i));
			professors.get(i).set_myteachingcourses(c);
			flag=1;
			break;
		}
		else
			flag=0;
	}
	if(flag==0)
	{
	Professor p=new Professor();
	p.set_myname(splits[3]);
	nop++;
	p.set_myid(nop);
	c.set_myprofessor(p);
	p.set_myteachingcourses(c);
	professors.add(p);
	}
	courses.add(c);
}
int noc=0;
String temp1=sc2.nextLine();
while(sc2.hasNextLine())
{
	String[] splits=sc2.nextLine().split(" ");
	Classroom s=new Classroom();
	s.set_myname(splits[0]);
	s.set_mycapacity(Integer.parseInt(splits[1]));
	if(splits[2].equals("Lec"))
	{
	Classroomtype Lec=new Classroomtype("Lec","bench");
	s.set_mytype(Lec);
	}
	else if(splits[2].equals("Lab"))
	{
		Classroomtype Lab=new Classroomtype("Lab","computer");
		s.set_mytype(Lab);
	}
	noc++;
	s.set_myid(noc);
	
	classrooms.add(s);
}
int nos=0;
String temp2=sc3.nextLine();
while(sc3.hasNextLine())
{
	Student t=new Student();
	String[] splits=sc3.nextLine().split(",");
	t.set_myid(Integer.parseInt(splits[0]));
	t.set_myname(splits[1]);
	nos++;
	for(int i=0;i<splits.length-2;i++)
	{
		for(int j=0;j<courses.size();j++)
		{
			if(courses.get(j).get_myid().equals(splits[i+2]))
			{
				t.set_mylearningcourses(courses.get(j));
				courses.get(j).set_mystudents(t);
			}
		}
	}
	students.add(t);
}
int nog=0;
String[] temp=new String[1000];
for(int i=0;i<nos;i++)
{
	if(students.get(i).get_mylearningcourses().size()==5)
	{
	int count=0;
	if(i==0)
	{
		temp[nog]=students.get(i).get_mylearningcourses().get(3).get_myid()+students.get(i).get_mylearningcourses().get(4).get_myid();
		nog++;
		continue;
	}
	for(int j=0;j<temp.length;j++)
	{
		if((students.get(i).get_mylearningcourses().get(3).get_myid()+students.get(i).get_mylearningcourses().get(4).get_myid()).equals(temp[j]) || (students.get(i).get_mylearningcourses().get(4).get_myid()+students.get(i).get_mylearningcourses().get(3).get_myid()).equals(temp[j]))
		{
			count++;
		}
	}
	if(count==0)
	{
		temp[nog]=students.get(i).get_mylearningcourses().get(3).get_myid()+students.get(i).get_mylearningcourses().get(4).get_myid();
		nog++;
	}
}
}

String[] week={"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};

for(int j=0;j<professors.size();j++)
{ArrayList<Lecture>lectures;
	ArrayList<Day>days=new ArrayList<Day>();
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
	professors.get(j).setDays(days);
}
for(int j=0;j<students.size();j++)
{ArrayList<Lecture>lectures;
	ArrayList<Day>days=new ArrayList<Day>();
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
	students.get(j).setDays(days);
}
String alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
int i;
for(i=0;i<nog;i++)
{
	StudentsGroup sg=new StudentsGroup();
	sg.set_myid(i+1);
	sg.set_myname(alphabet.substring(i, i+1));
	for(int j=0;j<nos;j++)
	{
		if(students.get(j).get_mylearningcourses().size()==5)
		{
		if((students.get(j).get_mylearningcourses().get(3).get_myid()+students.get(j).get_mylearningcourses().get(4).get_myid()).equals(temp[i]) || (students.get(j).get_mylearningcourses().get(4).get_myid()+students.get(j).get_mylearningcourses().get(3).get_myid()).equals(temp[i]))
		{
			sg.set_mystudents(students.get(j));
		}
		}
	}
	sg.set_mycourses(sg.get_mystudents().get(0).get_mylearningcourses());
	studentsgroups.add(sg);
}
Betch bh1=new Betch(studentsgroups,courses,classrooms,professors,students,students.size());
bh1.setdays();
bh1.maketimetable();
System.out.println("weekly Timetable:");
bh1.printtimetable();
bh1.personaltimetable();
	}
}
