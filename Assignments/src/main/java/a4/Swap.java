package a4;

import java.util.ArrayList;
import java.util.List;

public class Swap {
	
	public static List swap(List l, int a, int b) {
		List rList = new ArrayList<>();
		
		for(int i = 0; i < l.size(); i++) {
			if(i == a) {
				rList.add(l.get(b));
			} else if (i == b) {
				rList.add(l.get(a));
			} else {
				rList.add(l.get(i));
			}
			
		}
		
		return rList;
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<>();
		list.add(11);
		list.add(22);
		list.add(33);
		list.add(44);
		System.out.println(swap(list, 1, 3));
		

	}

}
