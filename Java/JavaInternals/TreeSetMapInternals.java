package JavaInternals;

import java.util.Comparator;
import java.util.HashSet;
import java.util.TreeSet;

class DataComparator implements Comparator<Data>{
	@Override
	public int compare(Data arg0, Data arg1) {
		return arg0.getId() - arg1.getId();
	}
}
public class TreeSetMapInternals {

	public static void main(String[] args){
		Data d1 = new Data(1,1);
		Data d2 = new Data(2,2);
		Data d3 = new Data(3,3);
		Data d4 = new Data(4,4);
		Data d5 = new Data(1,5);
		Data d6 = new Data(2,6);
		Data d7 = new Data(3,7);
		Data d8 = new Data(4,8);
		
		TreeSet<Data> set = new TreeSet<Data>(new DataComparator());
		//HashSet<Data> set = new HashSet<Data>();
		set.add(d5);
		set.add(d6);
		set.add(d7);
		set.add(d8);
		set.add(d1);
		set.add(d2);
		set.add(d3);
		set.add(d4);
		System.out.println(set);
		
	}
}
