package JavaInternals;

import java.util.HashMap;

//Best practice for user defined key class is to make it immutable . 
//As String class is immutable so we got correct answer here because key in entry is still pointing to old object . 
//
public class HashMapKeyProperties {

	
	public static void main(String[] args){
		//Immutable class ;
		HashMap<String ,String > map = new HashMap<>();
		String s = new String("Akash Deep");
		map.put(s,"Singh");
		s=s.substring(2);
		System.out.println(map.get("Akash Deep"));
		//Muttable class 
		HashMap<Node ,String > map2 = new HashMap<>();
		Node n = new Node("Akash Deep");
		map2.put(n,"Singh");
		//Inside map key is still pointing to n . here we are changing n value to Deep .
		n.setName("Deep");
		System.out.println(map2.get(new Node("Akash Deep")));
		
	}
}
class Node {
	String s ;
	Node(String s ){
		this.s = s;
	}
	public void setName(String s){
		this.s = s;
	}
}
