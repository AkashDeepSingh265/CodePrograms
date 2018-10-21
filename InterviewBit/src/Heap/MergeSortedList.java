package Heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class ListNode {
     public int val;
     public ListNode next;
     ListNode(int x) { val = x; next = null; }
}

class ListNodeComparator<ListNode> implements Comparator<Heap.ListNode>{

    @Override
    public int compare(Heap.ListNode o1, Heap.ListNode o2) {
        return o1.val - o2.val;
    }
}

public class MergeSortedList {
    public ListNode mergeKLists(ArrayList<ListNode> a) {
        PriorityQueue<ListNode> heap = new PriorityQueue(new ListNodeComparator<>());
        for (ListNode node: a){
            heap.add(node);
        }
        ListNode head = null;
        ListNode prev = null;
        while(!heap.isEmpty()){
            ListNode current = heap.poll();
            if(head == null){
                head = current;
                prev = current;
                if(current.next !=null){
                    heap.add(current.next);
                }
            }else{
                prev.next = current;
                prev = current;
                if(current.next !=null){
                    heap.add(current.next);
                }
            }

        }
        return head;
    }
}
