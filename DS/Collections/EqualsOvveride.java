package Collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.NavigableSet;
import java.util.TreeMap;
import java.util.TreeSet;

class Car implements Comparable<Car>{
	private int vehicleNo ;
	private int id ;
	
	public Car(int vehicle,int id){
		this.vehicleNo = vehicle;
		this.id = id;
	}
	
	public int hashCode(){
		return vehicleNo*17;
	}
	public boolean equals(Object o){
		if(o instanceof Car && ((Car)o).vehicleNo == this.vehicleNo){
			return true;
		}
		return false;
	}

	@Override
	public int compareTo(Car paramT) {
		return new Integer(vehicleNo).compareTo(paramT.vehicleNo);
	}
}

public class EqualsOvveride {

	public static void main(String[] args){
		
		Car a = new Car(1,1);
		Car b = new Car(2,2);
		Car c = new Car(3,3);
		Car d = new Car(1,1);
		Car e = new Car(2,5);
		Car f = new Car(1,6);
		HashMap<Car,String> map = new HashMap<>();
		
		Map<Car,String> syncMap =   Collections.synchronizedMap(map);
		syncMap.entrySet().iterator();
		map.put(a,"a");
		map.put(b,"b");
		map.put(c,"c");
		System.out.println(map.put(d,"d"));
		map.put(e,"e");
		System.out.println(map.put(f, "f"));
		System.out.println(map.get(new Car(1,8)));
		HashSet<Car> set = new HashSet<>();
		set.add(a);
		set.add(b);
		set.add(c);
		set.add(d);
		set.add(e);
	}
}
