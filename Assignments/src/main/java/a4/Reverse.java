package a4;

import java.util.ArrayList;
import java.util.List;

public class Reverse {
	
	public static List reverse(List a) {
		List rList = new ArrayList<>();
		for(int i = a.size()-1; i >= 0; i--) {
			rList.add(a.get(i));
		}
		return rList;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		List r = reverse(list);
		System.out.println(r);

	}

}
