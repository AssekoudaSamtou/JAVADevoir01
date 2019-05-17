package exercice01;

import java.util.Vector;

public class Stack {
	
	private Vector<Object> elements;
	private int indice = 0;
	
	public Stack() {
		elements = new Vector<Object>();
	}
	
	public Object push(Object item) {
		elements.add(indice, item);
		indice++;
		return item;
	}
	
	public Object pop() {
		Object result = elements.elementAt(indice-1);
		indice--;
		return result;
	}
	
	public Object peek() {
		Object result = elements.elementAt(indice-1);
		indice--;
		return result;
	}

	public boolean empty() {
		return indice == 0 ;
	}
	
	public int search(Object o) {
		int resultat = -1;
		for (int i = 0; i < indice; i++) {
			if (elements.elementAt(i) == o) {
				resultat = i;
				break;
			}
		}
		return resultat;
	}

	public static void main(String[] args) {
		Stack myStack = new Stack();
		myStack.push("ama");
		myStack.push("omo");
		myStack.push("imi");
		myStack.pop();
		System.out.println(myStack.empty());
		System.out.println(myStack.search("imi"));
	}
}
