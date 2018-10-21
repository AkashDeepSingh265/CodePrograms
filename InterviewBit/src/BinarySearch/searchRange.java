package BinarySearch;
import java.util.*;
/**
 * Created by akash.ds on 25/08/18.
 * https://www.interviewbit.com/problems/search-for-a-range/
 */
public class SearchRange {

    public int find_starting(List<Integer> a, int b){
        int start = 0 ;
        int end = a.size()-1;
        while(start <= end){
            if(end==start && a.get(end)==b){
                return start;
            }
            int mid = start + (end - start)/2;
            if(a.get(mid)==b && mid-1 >=start && a.get(mid-1)!=b ){
                return mid;
            }
            if(mid == start && a.get(mid)==b){
                return mid;
            }

            if(a.get(mid) < b){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return -1;
    }

    public int find_ending(List<Integer> a, int b){
        int start = 0 ;
        int end = a.size()-1;
        while(start <= end){
            if(end==start && a.get(end)==b){
                return start;
            }
            int mid = start + (end - start)/2;
            if(a.get(mid)==b && mid+1 <= end && a.get(mid+1)!=b ){
                return mid;
            }
            if(mid == end && a.get(mid)==b){
                return mid;
            }

            if(a.get(mid) <= b ){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return -1;
    }
    // DO NOT MODIFY THE LIST
    public ArrayList<Integer> searchRange(final List<Integer> a, int b) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int starting_index = find_starting(a,b);
        int ending_index = find_ending(a,b);
        result.add(starting_index);
        result.add(ending_index);
        return result;

    }
}

