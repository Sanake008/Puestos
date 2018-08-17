package Entity;
import javax.persistence.*;

@Entity
@Table(name = "employee")
@Inheritance(strategy=InheritanceType.JOINED)
public class Employee 
{
	
	private int id;
	private String firstName;
	private String lastName;
	private int salary;
	
	public Employee(){}
	public Employee(String first_name, String last_name, int Salary)
	{
		this.firstName = first_name;
		this.lastName = last_name;
		this.salary = Salary;
	}
	public Employee(int id, String first_name, String last_name, int salary)
	{
		this.id = id;
		this.firstName = first_name;
		this.lastName = last_name;
		this.salary = salary;
	}
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name = "first_name")
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	@Column(name = "last_name")
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Column(name = "salary")
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString()
	{
		return "Id = " + id + " || First Name = "+ firstName +" || Last Name = " + lastName +" || Salary = " + salary;
	}
}
