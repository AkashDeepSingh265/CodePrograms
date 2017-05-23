import java.util.NavigableSet;
import java.util.TreeSet;


public class TreeSetTreeMap {

	public static void main(String[] args){
		TreeSet<Integer> set = new TreeSet<Integer>();
		set.add(1230);
		set.add(1130);
		set.add(1330);
		set.add(930);
		NavigableSet<Integer> subSet = set.tailSet(1130,true);
		//set.add(1100);
		//subSet.add(1120);
		System.out.println(subSet);
		System.out.println(set);
		System.out.println(subSet.pollFirst());
		System.out.println(subSet);
		System.out.println(set);
		System.out.println(set.pollFirst());
		System.out.println(subSet);
		System.out.println(set);
	}
}
