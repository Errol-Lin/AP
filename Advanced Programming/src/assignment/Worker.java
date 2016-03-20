package assignment;

public class Worker extends Employee {
	
	private double hourRate;
	private int totalHour;
	private int totalParts;
	private Supervisor sv;

	Worker(String ID, String name, double rate, Supervisor sp){
		super(ID,name);
		this.hourRate = rate;
		this.sv = sp;
		this.totalHour = 0;
		this.totalParts = 0;
	}
	
	public void addHoursParts(double hour, int part) throws ExcessHoursException{
		this.totalHour += hour;
		this.totalParts += part;
		sv.addTeamParts(part);
		
		if(totalHour > 200){
			int excess = totalHour - 200;
			totalHour = 200;
			throw new ExcessHoursException("Excess Hours", excess);
		}
	}
	
	@Override
	public double grossSalary() {
		double salary = (totalParts > 100) ? (totalHour*hourRate + 100 + (totalParts - 100)*4) : (totalHour*hourRate);
		return salary;
	}

}
