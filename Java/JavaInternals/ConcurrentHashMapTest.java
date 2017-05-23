package JavaInternals;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest {

	public static void main(String[] args){
		ConcurrentHashMap<String,String> cMap = new ConcurrentHashMap<>();
		cMap.putIfAbsent("a", "A");
		cMap.putIfAbsent("b", "B");
		cMap.putIfAbsent("c", "C");
		cMap.putIfAbsent("d", "D");
	}
	
	
}
