package Generics;

import java.util.*;

public final class Algorithm {
    public static <T extends Object & Comparable<? super T>>
        T max(List<? extends T> list, int begin, int end) {

        T maxElem = list.get(begin);

        for (++begin; begin < end; ++begin)
            if (maxElem.compareTo(list.get(begin)) < 0)
                maxElem = list.get(begin);
        return maxElem;
    }
    public static void main(String[] args){
    	List<Integer> lst = new ArrayList<Integer>();
    	lst.add(3);
    	lst.add(2);
    	lst.add(6);
		Algorithm.<Integer>max(lst, 0, 2);
    }
}