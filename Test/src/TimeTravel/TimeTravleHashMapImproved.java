package TimeTravel;

import java.util.ArrayList;
import java.util.HashMap;

class TimeValue{
	private int time;
	private  String Value;
	
	public TimeValue(int time , String value) {
		this.time = time;
		this.Value = value;
	}
	
	public int getTime(){
		return this.time;
	}
	
	public String getValue(){
		return this.Value;
	}
}
public class TimeTravleHashMapImproved {
private static HashMap<String, ArrayList<TimeValue>> timetravelMap = new HashMap<>();
	
	private static  int curTime = 1;
	private static int getTime(){
		int retval = curTime;
		curTime = curTime+4;
		return retval;
	}
	
	public void put(String key,String Value){
		if(key == null || Value == null) return ;
		int time = TimeTravleHashMapImproved.getTime();
		TimeValue obj = new TimeValue(time ,Value);
		if(timetravelMap.get(key)!=null){
			timetravelMap.get(key).add(obj);
		}else{
			ArrayList<TimeValue> list = new ArrayList<>();
			list.add(obj);
			timetravelMap.put(key,list);
		}
	}
	
	public String get(String key , int time ){
		if(key == null || time < 1) return null;
		if(timetravelMap.get(key)==null) return "Key Not present in map ";
		ArrayList<TimeValue> list = timetravelMap.get(key);
		
		if(list.size()==1){
			if(time>=list.get(0).getTime()){
				return list.get(0).getValue();
			}
			return null;
		}else{
			TimeValue obj = binarySearch(list, time,0,list.size()-1);
			if(obj==null)return null;
			return obj.getValue();
		}
	}
	
	private TimeValue binarySearch(ArrayList<TimeValue> list , int time,int start , int end){
		if(start>end) return null;
		if(time < list.get(start).getTime()) return null;
		if(time > list.get(end).getTime()) return list.get(end);
		if(start==end) return list.get(start);
		int mid = (start + end)/2;
		if(list.get(mid).getTime()==time) return list.get(mid);
		if(time < list.get(mid).getTime()){
			if(mid-1>=start&& time >= list.get(mid-1).getTime()) return list.get(mid-1);
			return binarySearch(list, time, start,mid-1);
		}else{
			if(mid+1<=end&& time < list.get(mid+1).getTime()) return list.get(mid);
			return binarySearch(list, time, mid+1,end);
			
		}
	}
	
	public static void main(String[] args){
		TimeTravleHashMapImproved map = new TimeTravleHashMapImproved();
		map.put("Akshat", "India");
		map.put("Akshat", "Delhi");
		map.put("Akshat", "Gurgaon");
		map.put("Akash", "bangalore");
		map.put("Akash", "Mysore");
		for(int i = -2 ; i < 20 ; i ++){
			System.out.println(i+":"+map.get("Akshat", i));
		}
		for(int i = -2 ; i < 20 ; i ++){
			System.out.println(i+":"+map.get("Akash", i));
		}
		
	}
}
