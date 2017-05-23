package JavaInternals;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
// Collection Interface has iterator method . so all the collection conctrete class have iterators . 
// In case of map there is no iterator . so we have to iterate over either entry set or keySet . As they are set they have iterators .
//We can clone map also . By using clone method as Hash map extends Cloneable .
public class HashMapInternal {

	public static void main(String[] args){
		Data d1 = new Data(1,1);
		Data d2 = new Data(2,2);
		Data d3 = new Data(3,3);
		Data d4 = new Data(4,4);
		Data d5 = new Data(1,5);
		Data d6 = new Data(2,6);
		Data d7 = new Data(3,7);
		Data d8 = new Data(4,8);
		HashMap<Data,String> map = new HashMap<>();
		Map<Data,String> map2 = new LinkedHashMap<>();
		
		map.put(d5,"e");
		map.put(d6,"f");
		map.put(d7,"g");
		map.put(d8,"h");
		map.put(d1,"a");
		map.put(d2,"b");
		map.put(d3,"c");
		HashMap<Data,String> map1 = (HashMap<Data, String>) map.clone();
		Iterator it = map.entrySet().iterator();
		int count=0;
		while(it.hasNext()){
			Map.Entry pairs = (Map.Entry)it.next();
			pairs.getKey();
			if(count==4){
				map.put(d4,"d");
			}
			System.out.println(pairs.getKey() +","+ pairs.getValue());
			count++;
		}
	}
}
