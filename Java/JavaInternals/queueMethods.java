package JavaInternals;

import java.util.PriorityQueue;

public class queueMethods {

	public static void main(String[] args){
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		queue.add(3);
		queue.add(1);
		queue.add(7);
		queue.add(4);
		queue.add(2);
		queue.add(5);
		queue.add(0);
		while(!queue.isEmpty()){
			System.out.println(queue.remove());
		}
	}
}
