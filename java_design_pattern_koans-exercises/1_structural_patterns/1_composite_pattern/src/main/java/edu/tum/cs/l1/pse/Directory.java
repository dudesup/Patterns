package edu.tum.cs.l1.pse;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Directory {

	
	//TODO: add the missing inheritance
	//TODO: add the missing field
	//TODO: add the missing methods
	

	public Directory(String name) {
		super(name);
	}
	

	@Override
	public void list(int level) {
		printName(level);

		Iterator<FileSystemObject> iterator = children.iterator();
		while (iterator.hasNext()) {
			FileSystemObject child = (FileSystemObject) iterator.next();
			child.list(level + 1);
		}
	}



}
