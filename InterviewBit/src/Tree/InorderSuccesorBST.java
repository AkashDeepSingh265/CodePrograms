package Tree;
/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class InorderSuccesorBST {
    public TreeNode getSuccessor(TreeNode a, int b) {
        TreeNode cur = a;
        TreeNode ancestor = null;
        while(cur.val !=b){
            if(cur.val > b){
                ancestor = cur;
                cur = cur.left;
            }else{
                cur = cur.right;
            }
        }
        if(cur.right!=null){
            cur = cur.right;
            while(cur.left!=null){
                cur=cur.left;
            }
            return cur;
        }else{
            return ancestor;
        }

    }
}
