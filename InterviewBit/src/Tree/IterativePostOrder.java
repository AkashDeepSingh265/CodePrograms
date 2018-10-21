package Tree;
import java.util.*;
/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class IterativePostOrder {
    public ArrayList<Integer> postorderTraversal(TreeNode A) {
        if(A==null){
            return null;
        }

        ArrayList<Integer> return_array = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode current = A;
        while(!stack.isEmpty() || current!=null){
            while(current!=null){
                stack.push(current);
                return_array.add(current.val);
                current = current.right;
            }
            current = stack.pop();
            current = current.left;
        }
        Collections.reverse(return_array);
        return return_array;
    }
}

