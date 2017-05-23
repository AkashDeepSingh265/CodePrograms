package IteratorsTest;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

//In case of Fail Safe as it operates on copied Data structure. it doesnt throw concurrent modification exception if any 
//structural changes are done to original datastructure . Those changes are reflected while iterating . 
public class FailSafeIterator {

	 public static void main(String[] args)
	    {
	        ConcurrentHashMap<String,String> premiumPhone = new ConcurrentHashMap<String,String>();
	        premiumPhone.put("Apple", "iPhone");
	        premiumPhone.put("HTC", "HTC one");
	        premiumPhone.put("Samsung","S5");
	        
	        Iterator iterator = premiumPhone.keySet().iterator();
	        while (iterator.hasNext())
	        {
	            System.out.println(premiumPhone.get(iterator.next()));
	            //iterator.remove();
	            premiumPhone.put("Sony", "Xperia Z");
	        }
	    }
}
