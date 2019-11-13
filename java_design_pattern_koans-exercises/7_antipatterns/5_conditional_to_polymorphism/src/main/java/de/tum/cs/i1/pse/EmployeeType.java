package de.tum.cs.i1.pse;

//TODO Remove the EmployeeType class
//TODO Add Employee subclasses for Manager and Engineer

/////////////////////////////////
// superclass
/////////////////////////////////
abstract class EmployeeType {
	 public static final int ENGINEER = 0;
	 public static final int MANAGER = 1;
	 
	 abstract public int getTypeCode();
}

/////////////////////////////////
// subclass: Engineer
/////////////////////////////////
class Engineer extends EmployeeType {
	@Override
	public int  getTypeCode() {
		return EmployeeType.ENGINEER;
	}
}

/////////////////////////////////
// subclass: Manager
/////////////////////////////////
class Manager extends EmployeeType {
	@Override
	public int getTypeCode() {
		return EmployeeType.MANAGER;
	}
}
