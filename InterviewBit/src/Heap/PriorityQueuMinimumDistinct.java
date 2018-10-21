package Heap;

import java.util.*;

/**
 * Created by akash.ds on 02/10/18.
 */

class Node{
    int value;
    int count;

    public Node(int value, int count){
        this.value = value;
        this.count = count;
    }

//    public boolean equals(Object obj){
//        if (this == obj)
//            return true;
//        if (obj == null)
//            return false;
//        if (getClass() != obj.getClass())
//            return false;
//        Node other = (Node) obj;
//        if (value != other.value)
//            return false;
//        return true;
//    }
//
//    public int hashCode(){
//        return value;
//    }
}
public class PriorityQueuMinimumDistinct {
    public static void main(String[] args){
        int[] array = {2, 4, 1, 5, 3, 5, 1, 3};
        int m=2;
        PriorityQueue<Node> heap = new PriorityQueue(new Comparator<Node>(){
            public int compare(Node node1 , Node node2){
                return node1.count - node2.count;
            }
        });

        //HashSet<Node> set = new HashSet<>();
//        for(int element : array){
//            Node node = new Node(element,1);
//            if(set.contains(node)){
//                System.out.println("Already_in_set"+node.value);
//            }else{
//                set.add(node);
//            }
//        }

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int element : array){
            if(map.containsKey(element)){
                map.put(element,map.get(element)+1);
            }else{
                map.put(element,1);
            }
        }

        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer,Integer> pair = (Map.Entry)it.next();
            heap.add(new Node(pair.getKey(),pair.getValue()));
        }
        while (m>0){
            int min_value = heap.peek().count;
            if(heap.peek().count <= m){
                heap.poll();
            }
            m = m-min_value;
        }

        System.out.print(heap.size());
    }
}
