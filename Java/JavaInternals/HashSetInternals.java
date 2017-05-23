package JavaInternals;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Hashtable;

class Data{
	private int val;
	private int id;
	
	public Data(int val,int id){
		this.val = val;
		this.id = id;
	}
	public boolean equals(Object o){
		if(o instanceof Data && this.val == ((Data) o).val && this.id == ((Data) o).id){
			return true;
		}else{
			return false;
		}
	}
	
	public int hashCode(){
		return this.val*this.id;
	}
	public int getId(){
		return this.id;
	}
	public String toString(){
		return id+"";
	}
}
public class HashSetInternals {
	
	public static void main(String[] args){
		HashSet<Data> set = new HashSet<>();
		Data d1 = new Data(1,1);
		Data d2 = new Data(2,2);
		Data d3 = new Data(3,3);
		Data d4 = new Data(4,4);
		Data d5 = new Data(1,5);
		Data d6 = new Data(2,6);
		Data d7 = new Data(3,7);
		Data d8 = new Data(4,8);
		set.add(d1);
		set.add(d2);
		set.add(d3);
		set.add(d4);
		set.add(d5);
		set.add(d6);
		set.add(d7);
		set.add(d8);
		System.out.println(set.contains(new Data(1,5)));
		String[] s =  new String[3];
	}
}
