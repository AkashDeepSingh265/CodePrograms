package Arrays; /**
 * Definition for an interval.
 * public class Arrays.Interval {
 *     int start;
 *     int end;
 *     Arrays.Interval() { start = 0; end = 0; }
 *     Arrays.Interval(int s, int e) { start = s; end = e; }
 * }
 */
import java.util.*;
class Interval {
         int start;
         int end;
         Interval() { start = 0; end = 0; }
         Interval(int s, int e) { start = s; end = e; }
     }


class SortbyStart implements Comparator<Interval>
{
    public int compare(Interval a, Interval b)
    {
        return a.start - b.start;
    }
}

public class MergeIntervals {

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        Collections.sort(intervals,new SortbyStart());
        ArrayList<Interval> return_list = new ArrayList<Interval>();
        Iterator<Interval> it = intervals.iterator();
        it.hasNext();
        Interval cur_int = it.next();
        return_list.add(cur_int);
        while(it.hasNext()){
            cur_int = it.next();
            Interval to_compare_interval = return_list.get(return_list.size()-1);
            if(is_overlaping_inteval(cur_int,to_compare_interval)){
                Interval merged_iterval = merge_interval(cur_int,to_compare_interval);
                return_list.set(return_list.size()-1,merged_iterval);
            }else{
                return_list.add(cur_int);
            }

        }
        return return_list;
    }

    public boolean is_overlaping_inteval(Interval cur_int, Interval to_compare_interval){
        if (cur_int.start >= to_compare_interval.start){
            return cur_int.start <= to_compare_interval.end;
        }else{
            return to_compare_interval.start <= cur_int.end;
        }
    }

    public Interval merge_interval(Interval cur_int, Interval to_compare_interval){
        return new Interval(Math.min(cur_int.start,to_compare_interval.start),Math.max(cur_int.end,to_compare_interval.end));
    }
}
