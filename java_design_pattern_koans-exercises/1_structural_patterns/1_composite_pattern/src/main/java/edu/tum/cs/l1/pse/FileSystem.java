package edu.tum.cs.l1.pse;

public class FileSystem {

	public static void main(String[] args) {
		FileSystemObject root = createFileSystem();
		list(root);
	}

	public static void list(FileSystemObject root) {
		root.list(0);
	}

	private static FileSystemObject createFileSystem() {
		Directory root = new Directory("root");
		root.addChild(new File("File A"));
		root.addChild(new File("File B"));

		Directory dir1 = new Directory("Directory 1");
		dir1.addChild(new File("File 1A"));
		dir1.addChild(new File("File 1B"));

		root.addChild(dir1);
		return root;
	}

}
