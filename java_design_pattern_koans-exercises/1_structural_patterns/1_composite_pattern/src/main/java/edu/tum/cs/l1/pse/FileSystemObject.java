package edu.tum.cs.l1.pse;

import java.util.Arrays;

public abstract class FileSystemObject {
	
	private final String name;
	
	public FileSystemObject(String name){
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	private String getLevelPrefix(int level){
		char[] charArray = new char[level];
		Arrays.fill(charArray, '-');
		return new String(charArray);
	}
	
	public void printName(int level){
		System.out.print("\n" + getLevelPrefix(level) + getName());
	}
	
	public abstract void list(int level);

}
