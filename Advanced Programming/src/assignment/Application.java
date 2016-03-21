package assignment;
import java.util.*;
import java.io.*;

public class Application {

	public static void main(String[] args) throws IOException{
		Employee[] emps = new Employee[6];
		
		emps[0] = new Supervisor("s001","John Major", 2000);
		emps[1] = new Supervisor("s002","Bill Turner", 2500);
		emps[2] = new Worker("w001","Henry Chan", 25.0, (Supervisor) emps[0]);
		emps[3] = new Worker("w002","Tom Jones", 18.0, (Supervisor) emps[0]);
		emps[4] = new Worker("w003","Peter Ben", 20.0, (Supervisor) emps[1]);
		emps[5] = new Worker("w004","Phil Vines", 30.0, (Supervisor) emps[0]);
		
		//ConsoleReader rd = new ConsoleReader(System.in);
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter ID, total hours and number of parts:");
		String input = scanner.nextLine();
		
		while(input.length() != 0){
			StringTokenizer st = new StringTokenizer(input);
			String ID = st.nextToken();
			int totalHours = Integer.parseInt(st.nextToken());
			int totalParts = Integer.parseInt(st.nextToken());
			int i;
			for(i =2; i < 6; i++){
				if (emps[i].getID().equals(ID)){
					try{
						((Worker)emps[i]).addHoursParts(totalHours, totalParts);
					}
					catch(ExcessHoursException e){
						System.out.println(e.getErrorMessage());
						System.out.println(e.getExcessHour()+ " hours ignored");
					}
					break;
				}
			}
			
			if (i == 6) System.out.println("No Worker with this ID"); 
			//System.out.print("Enter ID daily-hours and parts : "); 
			input = scanner.nextLine(); 
		}
		
		Employee.setTaxRate(0.3);
		
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("salary.dat")));
		for (int i=0; i<6; i++) 
			pw.println("ID = " + emps[i].getID()+ "Name = " + emps[i].getName()+ " Gross Salary = " + emps[i].grossSalary()+ " Tax = " + emps[i].tax()); 
		pw.close();
	}

}
