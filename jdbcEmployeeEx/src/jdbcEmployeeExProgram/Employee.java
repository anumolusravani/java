package jdbcEmployeeExProgram;

public class Employee {
   private String eId;
   private String eName;
   private double eSalary;
public String geteId() {
	return eId;
}
public void seteId(String eId) {
	this.eId = eId;
}
public String geteName() {
	return eName;
}
public void seteName(String eName) {
	this.eName = eName;
}
public double geteSalary() {
	return eSalary;
}
public void seteSalary(double eSalary) {
	this.eSalary = eSalary;
}
@Override
public String toString() {
	return "Employee [eId=" + eId + ", eName=" + eName + ", eSalary=" + eSalary + "]";
}
}
