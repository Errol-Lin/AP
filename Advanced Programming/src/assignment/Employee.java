package assignment;

public abstract class Employee {
	private String name;
	private String ID;
	private static double taxRate;
	
	public Employee(String ID, String name){
		this.name = name;
		this.ID = ID;
	}
	
	public abstract double grossSalary();
	
	public static void setTaxRate(double rate){
		if(rate >= 0.1 && rate <= 0.5){
			Employee.taxRate = rate;
		}
	}
	
	public double tax(){
		double grossSalary = this.grossSalary();
		if(grossSalary <500)
			return 0;
		else
			return (grossSalary - 500)*taxRate;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getID(){
		return this.ID;
	}
}
