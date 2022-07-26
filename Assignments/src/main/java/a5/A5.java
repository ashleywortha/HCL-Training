package a5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Comparator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

class Employee{
	int id;
	String name;
	int age;
	String gender;
	String department;
	int yearOfJoining;
	int salary;
	public Stream<Employee> stream() {
		// TODO Auto-generated method stub
		return null;
	}
}

class PayComparator implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		Employee e1 = (Employee) o1;
		Employee e2 = (Employee) o2;
		if(e1.salary == e2.salary) {
			return 0;
		} else if (e1.salary < e2.salary) {
			return 1;
		} else {
			return -1;
		}
	}
	
}

class JoinComparator implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		Employee e1 = (Employee) o1;
		Employee e2 = (Employee) o2;
		
		if(e1.yearOfJoining == e2.yearOfJoining) {
			return 0;
		} if(e1.yearOfJoining > e2.yearOfJoining) {
			return 1;
		} else {
			return -1;
		}
	}
	
}

public class A5 {
	
	public static void main(String[] args) {
		List<Employee> list = new ArrayList<>();
		list.add( new Employee(1, "Peggy", 42, "f", "Beauty", 2010, 80000));
		list.add( new Employee(2, "Hank", 45, "m", "Maintenance", 2013, 75000));
		list.add(new Employee(3, "Bobby", 23, "m", "JClothing", 2022, 55000));
		list.add( new Employee(4, "Luanne", 30, "f", "Maintenance", 2015, 66000));
		list.add (new Employee(5, "Dale", 40, "m", "Home", 2007, 78500));
		list.add(new Employee(6, "Connie", 23, "f", "JClothing", 2021, 57000));
		list.add( new Employee(7, "Bill", 52, "m", "Maintenance", 2012, 50000));
		list.add (new Employee(8, "Nancy", 39, "f", "Beauty", 2009, 90000));
		list.add(new Employee(9, "Joseph", 22, "m", "JClothing", 2021, 50000));
		list.add( new Employee(10, "John", 55, "m", "Maintenance", 2014, 62000));
		list.add (new Employee(11, "Mike", 60, "m", "Home", 2008, 100000));
		
		//1
		System.out.println("1. # of Male and Female Employees");
		
		Map<Object, List<Employee>> map = list.stream()
				.collect(Collectors.groupingBy(e -> e.gender.equals("f")));
		List<List<Employee>> num = new ArrayList<>(map.values());
		System.out.println("Male Employees: " + num.get(0).size());
		System.out.println("Female Employees: " + num.get(1).size());
		
		//2
		System.out.println("2. Average age of Male and Female Employees");
		System.out.println("Male Employees: " + 
		 num.get(0).stream().mapToInt(a -> a.age).average().orElse(0));
		
		System.out.println("Female Employees: " + 
		num.get(1).stream().mapToInt(a -> a.age).average().orElse(0));
		
		//3
		Collections.sort(list, new PayComparator());
		System.out.println("3. Highest Paid Employee: " + list.get(0).name);
		
		//4
		Collections.sort(list, new JoinComparator());
		List<String> rList = new ArrayList<>();
		list.forEach((e) -> {
			if(e.yearOfJoining >=2015) {
				rList.add(e.name);
			}
		});
		
		System.out.println("4. Employees who joined after 2015: " + rList); 
		
		//5 
		System.out.println("5. Senior Most Employee: " + list.get(0).name);
		
		//6
		System.out.println("6. # of Employees in each Department");
		Map<String, Object> eByD = list.stream().collect(
				Collectors.groupingBy(Employee::getDepartment,
						Collectors.collectingAndThen(
								Collectors.mapping(Employee::getId, Collectors.toSet()), 
								Set::size)));
		System.out.println(eByD);
		
		
		
		//7
		System.out.println("7. Male & Female Employees in Maintenance Department");
		System.out.println("Male Employees: ");
		num.get(0).stream().filter(e -> e.department == "Maintenance").forEach((e) -> System.out.println(e.name));
		System.out.println("Female Employees: "); 
		num.get(1).stream().filter(e -> e.department == "Maintenance").forEach((e) -> System.out.println(e.name));
		
		//8
		System.out.println("8. Average Salary for Male & Female Employees");
		System.out.println("Male Employees: " + 
				 num.get(0).stream().mapToInt(a -> a.salary).average().orElse(0));
				
				System.out.println("Female Employees: " + 
				num.get(1).stream().mapToInt(a -> a.salary).average().orElse(0));
		
		//9
		System.out.println("9. Differentiate between the employees who are younger or equal to 30");
		Map<Object, List<Employee>> ageMap = list.stream()
				.collect(Collectors.groupingBy(e -> e.age <= 30));
		List<List<Employee>> diff = new ArrayList<>(ageMap.values());
		System.out.println("Employees 30 or younger: ");
		diff.get(1).forEach((e) -> System.out.println(e.name));
		System.out.println("Employees Over 30");
		diff.get(0).forEach((e) -> System.out.println(e.name));
		
		//10
		System.out.println("10. All Employees in each department");
		Map<String, List<Employee>> eByD2 = list.stream().collect(
				Collectors.groupingBy(Employee::getDepartment));
		eByD2.forEach((e, n) -> {System.out.println(e + ":");
			n.forEach((p) -> System.out.println(p.name));});
		
		
	}

}
