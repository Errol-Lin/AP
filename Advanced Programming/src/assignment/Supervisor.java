package assignment;

public class Supervisor extends Employee{
	private double baseSalary;
	private int totalTeamParts;
	
	public Supervisor(String name, String ID, double baseSalary){
		super(name,ID);
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
