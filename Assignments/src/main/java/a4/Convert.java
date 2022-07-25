package a4;

import java.util.HashSet;
import java.util.Set;

public class Convert {
	
	public static Object[] convert(Set s) {
		Object[] arr = s.toArray();
		return arr;
		
	}
	
	public static void main(String[] args) {
		Set<Integer> set = new HashSet<>();
		set.add(1);
		set.add(2);
		set.add(3);
		System.out.println(set);
		
		Object[] test = convert(set);
		for(int i = 0; i < test.length; i++) {
			System.out.print(test[i] + ", ");
		}

	}

}
