package a4;

import java.util.Iterator;
import java.util.LinkedList;

public class Iterate {
	
	static void iterate(LinkedList l, int s) {
		int k =0;
		Iterator i = l.listIterator(s);
		while(i.hasNext()) {
			System.out.println(i.next());
		} if(s > 0) {
			i = l.listIterator(k);
			while(k < s) {
				System.out.println(i.next());
				k++;
			}
			
		}
	}
	
	public static void main(String[] args) {
		LinkedList<String> l = new LinkedList<String>();
		l.add("Wednesday");
		l.add("Thursday");
		l.add("Friday");
		l.add("Monday");
		l.add("Tuesday");
		iterate(l, 3);
	
	}

}
