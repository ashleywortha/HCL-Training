package a4;

import java.util.LinkedList;

public class Replace {
	public static void replaceWith(LinkedList l, int local, Object var) {
		l.set(local, var);
		System.out.println(l);
		
	}
	public static void main(String[] args) {
		LinkedList<String> lList = new LinkedList<String>();
		lList.add("First");
		lList.add("Second");
		lList.add("Wrong");
		lList.add("Fourth");
		System.out.println(lList);
		replaceWith(lList, 2, "Third");

	}

}
