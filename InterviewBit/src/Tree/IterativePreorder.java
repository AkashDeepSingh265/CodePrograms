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

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
}
public class IterativePreorder {
    public ArrayList<Integer> preorderTraversal(TreeNode A) {
        if(A==null){
            return null;
        }

        ArrayList<Integer> return_array = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode current = A;
        stack.push(A);
        while(!stack.isEmpty() || current!=null){
            while(current!=null){
                stack.push(current);
                return_array.add(current.val);
                current = current.left;
            }
            current = stack.pop();
            current = current.right;
        }
        return return_array;
    }
}

