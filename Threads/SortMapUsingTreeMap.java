import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class SortMapUsingTreeMap {
	
	private class ScoreComparator implements Comparator<String> {
		Map<String,Double> baseMap;
		public ScoreComparator(Map<String,Double> baseMap){
			this.baseMap = baseMap;
		}
		@Override
		public int compare(String type1, String type2) {
			if(type1 == null && type2 == null){
				return 0;
			}
			if(type1 == null || baseMap.get(type1) == null){
				return -1;
			}
			if(type2 == null || baseMap.get(type2) == null){
				return 1;
			}
			double score1 = baseMap.get(type1);
			double score2 = baseMap.get(type2);
			if(score1 < score2){
				return 1;
			}
			else{
				return -1;
			}
		}
	}

	public void sortmap(){
		HashMap<String,Double> map = new HashMap<String, Double>();
		map.put("SONG",4.12);
		map.put("Album",1.22);
		map.put("Artist",2.345);
		map.put("PlayList",3.566);
		ScoreComparator scoreComp = new ScoreComparator(map);
		TreeMap<String, Double> unisearchOrderMap = new TreeMap<String, Double>(scoreComp);
		unisearchOrderMap.putAll(map);
		Set<String> orderedSet = unisearchOrderMap.keySet();
		System.out.println(orderedSet);
	}
	public static void main(String[] args){
		SortMapUsingTreeMap obj = new SortMapUsingTreeMap();
		obj.sortmap();
		
	}
}
