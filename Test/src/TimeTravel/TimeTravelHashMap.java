//package TimeTravel;
//
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.LinkedList;
//
////class TimeValue{
////	private int time;
////	private  String Value;
////	
////	public TimeValue(int time , String value) {
////		this.time = time;
////		this.Value = value;
////	}
////	
////	public int getTime(){
////		return this.time;
////	}
////	
////	public String getValue(){
////		return this.Value;
////	}
////}
//
//public class TimeTravelHashMap {
//
//	private static HashMap<String,LinkedList<TimeValue>> timetravelMap = new HashMap<>();
//	
//	private static  int curTime = 1;
//	private static int getTime(){
//		int retval = curTime;
//		curTime = curTime+4;
//		return retval;
//	}
//	public void put(String key,String Value){
//		if(key == null || Value == null) return ;
//		int time = TimeTravelHashMap.getTime();
//		TimeValue obj = new TimeValue(time ,Value);
//		if(timetravelMap.get(key)!=null){
//			timetravelMap.get(key).add(obj);
//		}else{
//			LinkedList<TimeValue> linkedList = new LinkedList<>();
//			linkedList.add(obj);
//			timetravelMap.put(key,linkedList);
//		}
//	}
//	
//	public String get(String key , int time ){
//		if(key == null || time < 1) return null;
//		if(timetravelMap.get(key)==null) return "Key Not present in map ";
//		LinkedList<TimeValue> list = timetravelMap.get(key);
//		
//		if(list.size()==1){
//			if(time>=list.get(0).getTime()){
//				return list.get(0).getValue();
//			}
//			return null;
//		}else{
//			TimeValue curObj , nextObj = null;
//			Iterator<TimeValue> it = list.iterator();
//			curObj = list.get(0);
//			it.hasNext();
//			it.next();
//			while(it.hasNext()){
//				nextObj = it.next();
//				if(curObj.getTime()<= time && time < nextObj.getTime()){
//					return curObj.getValue();
//				}else{
//					curObj = nextObj;
//				}
//			}
//			if(time>=curObj.getTime()){
//				return curObj.getValue();
//			}
//		}
//		return null;
//	}
//	
//	public static void main(String[] args){
//		TimeTravelHashMap map = new TimeTravelHashMap();
//		map.put("Akshat", "India");
//		map.put("Akshat", "Delhi");
//		map.put("Akshat", "Gurgaon");
//		for(int i = -2 ; i < 20 ; i ++){
//			System.out.println(map.get("Akshat", i));
//		}
//		
//		System.out.println(map.get("Akshat", 6));
//		System.out.println(map.get("Akshat", 11));
//		System.out.println(map.get("Akshat", -1));
//		
//	}
//}
