package edu.tum.cs.l1.pse;

public class File  {
	
	//TODO: add the missing inheritance

	public File(String name) {
		super(name);
	}

	@Override
	public void list(int level) {
		printName(level);
	}

}
