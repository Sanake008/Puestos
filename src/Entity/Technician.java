package Entity;

import javax.persistence.*;

@Entity
//@Table(name = "technician")
@PrimaryKeyJoinColumn(name = "employeeid")
public class Technician extends Employee
{
	private int experienceYears = 0;
	
	public Technician(String first_name, String last_name, int salary)
	{
		super(first_name, last_name, salary);
	}

	public int getExperienceYears() {
		return experienceYears;
	}

	public void setExperienceYears(int experienceYears) {
		this.experienceYears = experienceYears;
	}
}
