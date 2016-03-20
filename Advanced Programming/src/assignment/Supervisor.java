package assignment;

public class Supervisor extends Employee{
	private double baseSalary;
	private int totalTeamParts;
	
	public Supervisor(String ID, String name, double baseSalary){
		super(ID,name);
		this.baseSalary = baseSalary;
		this.totalTeamParts = 0;
	}
	
	public double grossSalary(){
		return this.baseSalary + this.totalTeamParts;
	}
	
	public void addTeamParts(int num){
		this.totalTeamParts += num;
	}

}
