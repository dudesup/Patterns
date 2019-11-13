package de.tum.cs.i1.pse;

//TODO Make the Employee class abstract
//caller class
public class Employee {
    private EmployeeType type;
	private int monthlySalary = 1000;
	private int bonus = 300;
	
	public Employee(EmployeeType type) {
		this.type = type;
	}
	
	//TODO Refactor this Method
    public int payAmount() {
        switch (getType()) {
            case EmployeeType.ENGINEER:
               return monthlySalary;
            case EmployeeType.MANAGER:
               return monthlySalary + bonus;
            default:
               throw new RuntimeException("Incorrect Employee");
        }
    }
   
    int getType() {
        return type.getTypeCode(); 
    }   
    
    public int getMonthlySalary() {
    	return monthlySalary;
    }
    
    public int getBonus() {
    	return bonus;
    }
    
    //main()

}

