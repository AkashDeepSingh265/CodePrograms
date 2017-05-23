import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class StringComparator implements Comparator<ComparableComparator>{
	@Override
	public int compare(ComparableComparator arg0, ComparableComparator arg1) {
		return arg0.getString().compareTo(arg1.getString());
	}
}

public class ComparableComparator implements Comparable<ComparableComparator>{

	private Integer a;
	private String s;
	
	public ComparableComparator(Integer a , String s){
		this.a = a;
		this.s = s;
	}
	@Override
	public int compareTo(ComparableComparator arg0) {
		return this.a.compareTo(arg0.a);
	}
	
	public String getString(){
		return s;
	}
	
	public String toString(){
		return a+","+s;
	}
	public static void main(String[] args){
		List<ComparableComparator> lst = new ArrayList<ComparableComparator>();
		lst.add(new ComparableComparator(1,"AKash"));
		lst.add(new ComparableComparator(5,"gogo"));
		lst.add(new ComparableComparator(2,"monika"));
		lst.add(new ComparableComparator(10,"mayo"));
		lst.add(new ComparableComparator(4,"naga"));
		lst.add(new ComparableComparator(3,"tedda"));
		lst.add(new ComparableComparator(9,"bitanka"));
		//Collections.sort(lst,new StringComparator());
		Collections.sort(lst);
		System.out.println(lst);
	}
	
	
}