package Stack;
import java.util.*;

public class LargestRectangleHistogram {
    public static int largestRectangleArea(List<Integer> A) {
        Stack<Integer> stack = new Stack();
        int[] result = new int[A.size()];
        for(int i=0; i < A.size() ; i++){

            while(!stack.isEmpty() && A.get(stack.peek()) >= A.get(i)){
                stack.pop();
            }
            if(stack.isEmpty()){
                result[i] = (i+1)*A.get(i);
            }else{
                result[i] = (i -stack.peek())*A.get(i);
            }
            stack.push(i);
        }
        System.out.println(Arrays.toString(result));
        stack.clear();



        for(int i= A.size()-1; i >= 0 ; i--){
            while(!stack.isEmpty() && A.get(stack.peek()) >= A.get(i)){
                stack.pop();
            }
            if(stack.isEmpty()){
                result[i] += (A.size() - i-1)*A.get(i);
            }else{
                result[i] += (stack.peek() -i-1)*A.get(i);
            }
            stack.push(i);
        }

        System.out.println(Arrays.toString(result));

        int max_element = Integer.MIN_VALUE;
        for(int element : result){
            max_element = Math.max(max_element,element);
        }

        return max_element;

    }

    public static void main(String[] args){
        List<Integer> input_list = Arrays.asList(90, 58, 69, 70, 82, 100, 13, 57, 47, 18 );
        System.out.print(largestRectangleArea(input_list));
    }
}
