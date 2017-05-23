package Others;

import java.util.HashMap;
import java.util.LinkedList;

import LinkedList.NodeLL;

public class LRUCache {
	private static NodeLL<Integer> head = null;
	private static HashMap<Integer,NodeLL<Integer>> map = new HashMap<Integer, NodeLL<Integer>>();
	
	public static void referenceFromLruCache(Integer pageNumber){
		if(map.get(pageNumber)!=null){
			
		}
	}
}
