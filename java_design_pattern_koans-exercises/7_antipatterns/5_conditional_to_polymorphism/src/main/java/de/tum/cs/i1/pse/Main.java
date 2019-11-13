package de.tum.cs.i1.pse;


//TODO Remove the EmployeeType class
//TODO Make the Employee class abstract
//TODO Add Employee subclasses for Manager and Engineer
//TODO Add a new Employee type, named Intern, whose monthly salary is half the salary of an Engineer

public class Main {
	public static void main(String[] args) {
		Employee jack = new Employee(new Engineer());
		Employee stephan = new Employee(new Manager());
		
		System.out.println("Payment amount=" + jack.payAmount());
		System.out.println("Payment amount=" + stephan.payAmount());
	}
}

