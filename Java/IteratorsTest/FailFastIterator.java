package IteratorsTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
// In case of Fail Fast as it operates on original Data structure. it throws exception when ever structural modifications are done to data structure
//Enhanced for loops use iterators internally . So when we try to modify data structure inside for lopp it throws concurrent modification exception

public class FailFastIterator {

	 public static void main(String[] args)
	    {
	        Map<String,String> premiumPhone = new HashMap<String,String>();
	        premiumPhone.put("Apple", "iPhone");
	        premiumPhone.put("HTC", "HTC one");
	        premiumPhone.put("Samsung","S5");
	        Iterator iterator = premiumPhone.keySet().iterator();
	        while (iterator.hasNext())
	        {
	            System.out.println(premiumPhone.get(iterator.next()));
	            iterator.remove();
	            premiumPhone.put("Sony", "Xperia Z");
	        }
	    }
	
	
//	public static void main(String[] args)
//    {
//        Map<String,String> premiumPhone = new HashMap<String,String>();
//        premiumPhone.put("Apple", "iPhone");
//        premiumPhone.put("HTC", "HTC one");
//        premiumPhone.put("Samsung","S5");
//        Iterator iterator = premiumPhone.keySet().iterator();
//        Iterator iterator2 = premiumPhone.keySet().iterator();
//        
//        while (iterator.hasNext())
//        {
//            System.out.println(premiumPhone.get(iterator.next()));
//            iterator2.next();
//            iterator2.remove();
//          //  iterator.remove();
//        }
//    }
	
	//Enhanced for loops use iterators internally . this will throw concurrent modification exception 
//	public static void main(String[] args)
//    {
//        Map<String,String> premiumPhone = new HashMap<String,String>();
//        premiumPhone.put("Apple", "iPhone");
//        premiumPhone.put("HTC", "HTC one");
//        premiumPhone.put("Samsung","S5");
//        for(String s:premiumPhone.keySet()){
//        	premiumPhone.put(s+"1",premiumPhone.get(s));
//        }
//    }
	
	// Simple for loop doesnt throw exception 
//	public static void main(String[] args)
//    {
//        Map<String,String> premiumPhone = new HashMap<String,String>();
//        premiumPhone.put("Apple", "iPhone");
//        premiumPhone.put("HTC", "HTC one");
//        premiumPhone.put("Samsung","S5");
//        for(int i = 0 ; i < premiumPhone.size();i++){
//        	premiumPhone.put(i+"",i+"");
//        }
//    }
}
