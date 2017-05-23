package Inside;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Liars {

	public static String[] findLiars(String[] relations , String liar){
		HashMap<String,List<String>> relationsMap = new HashMap<>();
		for(String relation : relations){
			String[] str = relation.split(",");
			if(!relationsMap.containsKey(str[0])){
				ArrayList<String> list = new ArrayList<>();
				list.add(str[1]);
				relationsMap.put(str[0], list);
			}else{
				relationsMap.get(str[0]).add(str[1]);
			}
			if(!relationsMap.containsKey(str[1])){
				ArrayList<String> list = new ArrayList<>();
				list.add(str[0]);
				relationsMap.put(str[1], list);
			}else{
				relationsMap.get(str[1]).add(str[0]);
			}
		}
		
		Set<String> liarSet = new TreeSet<String>();
		Set<String> truthSet = new TreeSet<String>();
		liarSet.add(liar);
		findLiarsDFS(liar,relationsMap,liarSet,truthSet);
		return  liarSet.toArray(new String[0]);
	}
	
	private static void findLiarsDFS(String source, HashMap<String, List<String>> relationsMap, Set<String> liarSet, Set<String> truthSet) {
		if(relationsMap.get(source)==null) return;
		for(String s : relationsMap.get(source)){
			if(truthSet.contains(s)||liarSet.contains(s))continue;
			if(truthSet.contains(source)){
				liarSet.add(s);
			}
			if(liarSet.contains(source)){
				truthSet.add(s);
			}
			findLiarsDFS(s, relationsMap, liarSet, truthSet);
		}
		
	}

	public static void main(String[] args){
		String[] array = {"ram,sita","george,sita","karthik,sita","ravi,george","karthik,bikash","bikash,mukul"};
		//String[] array = {"an,ka","deb,ka","roh,ka","ni,ka","ak,ka"};
		System.out.println(Arrays.toString(Liars.findLiars(array,"karthik")));
	}
}
