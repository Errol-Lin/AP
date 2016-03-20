package assignment;

public class ExcessHoursException extends Exception {
	private String errorMessage;
	private int excessHour;
	
	ExcessHoursException(String errorMessage, int excess){
		this.errorMessage = errorMessage;
		this.excessHour = (excess >=200) ? (excess-200) : excess;
	}
	
	public int getExcessHour(){
		return this.excessHour;
	}
	
	public String getErrorMessage(){
		return this.errorMessage;
	}

}
