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
public class IterativeInorder {
    public ArrayList<Integer> inorderTraversal(TreeNode A) {
        ArrayList<Integer> return_array = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode current = A;
        while(!stack.isEmpty() || current!=null){
            while(current!=null){
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            return_array.add(current.val);
            current = current.right;
        }
        return return_array;
    }
}
