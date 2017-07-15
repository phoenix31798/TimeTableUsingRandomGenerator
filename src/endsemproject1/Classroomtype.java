package endsemproject1;

public class Classroomtype {
private String _mytypename;
private String equipmenttype;
private int equipmentavailable;
public int getEquipmentavailable() {
	return equipmentavailable;
}
public void setEquipmentavailable(int equipmentavailable) {
	this.equipmentavailable = equipmentavailable;
}
public Classroomtype(String s,String q)
{
	_mytypename=s;
	equipmenttype=q;
}
public String get_mytypename() {
	return _mytypename;
}
public String getEquipmenttype() {
	return equipmenttype;
}

}
