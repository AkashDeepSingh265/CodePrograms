package JavaInternals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SynchronizingCollections {

	public static void main(String[] args){
		List<String> list = new ArrayList<>();
		List<String> lst = Collections.synchronizedList(list);
		System.out.println(list);
		lst.add("abc");
		System.out.println(list);
		
	}
}
