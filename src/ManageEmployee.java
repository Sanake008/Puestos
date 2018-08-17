

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session; 
import org.hibernate.Transaction;

import Entity.Developer;
import Entity.Employee;
import Entity.Technician;

public class ManageEmployee 
{
	//static List<Employee> employeesList;
   
	public static void main(String[] args) 
	{
		//InsertEmployeesInDataBase(EnterEmployees());
		QueryEmployees();
	}
   
	
	 public static void QueryEmployees( ){
	      Session session = HibernateUtil.getSessionFactory().openSession();
	      Transaction tx = null;
	      
	      try {
	         tx = session.beginTransaction();
	         String sql = "SELECT * FROM EMPLOYEE";
	         SQLQuery query = session.createSQLQuery(sql);	         
	         List<Object[]> employees = query.list();        
	         for (Object [] object : employees) 
	         {
	        	 Employee emp = new Employee(
	        			 Integer.parseInt(object[0].toString()), 
	        			 object[1].toString(), 
	        			 object[2].toString(), 
	        			 Integer.parseInt(object[3].toString())
	        			 );
				System.out.println(emp);
			}
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	   }
	
	public static void InsertEmployeesInDataBase(List<Employee> em)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		for (Employee employee : em) 
		{
			session.beginTransaction();
			session.save(employee);
			session.getTransaction().commit();
		}
		session.close();
	}
	 
	public static List<Employee> EnterEmployees()
	{
		int employeeN = 1 ;
		@SuppressWarnings("resource")
		Scanner rd = new Scanner(System.in);
		List<Employee>employeeList = new ArrayList<Employee>();
		while (!rd.next().equals("insert")) 
		{
			System.out.println("Welcome to the system please enter the employee's name");
			System.out.println("Enter the word 'insert' for insert the employees");
			System.out.println("Employee number " + employeeN);
			System.out.println("First Name: ");
			String first_name = rd.next();
			System.out.println("Last Name: ");
			String last_name = rd.next();
			System.out.println("Salary: ");
			int salary = rd.nextInt();
			System.out.println("Kind Of Employee (1) for Developer (2) for Technician: ");
			int kind_developer = rd.nextInt();
			if(kind_developer < 2)
			{
				System.out.println("Extpert Languajes: " );
				String languajes = rd.next();
				Developer developer = new Developer(first_name, last_name, salary);
				developer.setExpertLanguajes(languajes);
				employeeList.add(developer);
				employeeN ++;
			}
			else
			{
				System.out.println("Experience Years: ");
				int experience_years = rd.nextInt();
				Technician technician = new Technician(first_name, last_name, salary);
				technician.setExperienceYears(experience_years);
				employeeList.add(technician);
				employeeN++;
			}
		}
		System.out.println("El numero de la lista " + employeeList.size());
		return employeeList;
	}
}