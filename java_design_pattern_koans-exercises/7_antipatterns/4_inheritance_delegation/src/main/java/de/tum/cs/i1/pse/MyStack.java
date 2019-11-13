package de.tum.cs.i1.pse;

import java.util.Vector;




public class MyStack<T> extends Vector<T> {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public void push(T element) {
        insertElementAt(element,0);
    }

    public Object pop() {
        Object result = firstElement();
        removeElementAt(0);
        return result;
    }
    
    public Object top() {
    	return firstElement();
    }
 
    
    public static void main(String argv[]) {
    	MyStack<String> stack = new MyStack<String>();
    	
    	stack.push(new String("First Element"));
    	stack.push(new String("Second Element"));
    	stack.push(new String("Third Element"));
    	
    	System.out.println( stack.pop() );
    	System.out.println( stack.pop() );
    	System.out.println( stack.pop() );
    }
    
}