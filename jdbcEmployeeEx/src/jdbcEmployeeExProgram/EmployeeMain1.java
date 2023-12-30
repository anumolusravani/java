package jdbcEmployeeExProgram;

import java.util.List;

public class EmployeeMain1 {

	public static void main(String[] args) {
		EmployeeDao dao = new EmployeeDao();
		// table creation
		int createResult = dao.createEmployeeTable();
		System.out.println("Table creation status..."+createResult);
	}

}
class EmployeeMain2
{  
	public static void main(String[]args)
	{
	int result = 0;
	EmployeeDao dao = new EmployeeDao();
	//insert the data
	Employee employee1 = new Employee();
	employee1.seteId("es4512");
	employee1.seteName("harini");
	employee1.seteSalary(25000.52);
	result = dao.SaveEmployee(employee1);
	if(result==1)
	{
		System.out.println("Data inserted succesfully.."+result);
	}
	else
	{
		System.out.println("Data insertion fail check once.."+result);
	}
  }	
}
class EmployeeMain3
{  
	public static void main(String[]args)
	{
	
	EmployeeDao dao = new EmployeeDao();
	Employee employee = dao.findById("es4512");
		if(employee != null)
		{
			System.out.println("Employees are available.");
			System.out.println(employee.geteId()+" "+employee.geteName()+" "+employee.geteSalary());
		}
		else
		{
			System.out.println("Employee data is not available..");
		}
	  }
}
class EmployeeMain4
{ 
	public static void main(String[]args)
	{
	   EmployeeDao dao = new EmployeeDao();
	 List<Employee> employees = dao.findAll();
	 employees.forEach(employee->System.out.println(employee));
	}
	
}
class EmployeeMain5
{ 
	public static void main(String[]args)
	{
	   EmployeeDao dao = new EmployeeDao();
	   int count = dao.UpdateEmployee(10000,2000);
	   System.out.println("Updated records count .."+count);
	}
}
class EmployeeMain6
{ 
	public static void main(String[]args)
	{
	   EmployeeDao dao = new EmployeeDao();
	   int count = dao.deleteEmployeeById("es8712");
	   System.out.println("delete records count .."+count);
	}
}
class EmployeeMain7
{ 
	public static void main(String[]args)
	{
	   EmployeeDao dao = new EmployeeDao();
	   int count = dao.deleteEmployeeBySalary(32000);
	   System.out.println("delete records count .."+count);
	}
}
class EmployeeMain8
{ 
	public static void main(String[]args)
	{
	   EmployeeDao dao = new EmployeeDao();
	   int count = dao.DropTable();
	   System.out.println("Table is dropped status .."+count);
	}
} 
