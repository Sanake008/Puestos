package Entity;

import javax.persistence.*;
@Entity
//@Table(name = "developer")
@PrimaryKeyJoinColumn(name = "employeeid")
public class Developer extends Employee
{
	public Developer(String first_name, String last_name, int salary)
	{
		super(first_name,last_name,salary);
	}
	
	private String expertLanguajes = null;

	public String getExpertLanguajes() {
		return expertLanguajes;
	}

	public void setExpertLanguajes(String expertLanguajes) {
		this.expertLanguajes = expertLanguajes;
	}
}
