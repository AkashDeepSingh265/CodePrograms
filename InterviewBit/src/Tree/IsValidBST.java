package Tree;

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
public class IsValidBST {

    public int isValidBST(TreeNode root, int[] minmax){
        if(root == null ){
            return 1;
        }
        int[] minmaxLeftSubtree = new int[2];
        int isLeftSubtreeValid = isValidBST(root.left,minmaxLeftSubtree);
        if (isLeftSubtreeValid ==0 || root.left!=null && minmaxLeftSubtree[1] >= root.val){
            return 0;
        }
        int[] minmaxRightSubtree = new int[2];
        int isRightSubtreeValid = isValidBST(root.right,minmaxRightSubtree);
        if (isRightSubtreeValid ==0 || root.right!=null && minmaxRightSubtree[0] <= root.val){
            return 0;
        }
        if(minmax!=null){
            if(root.left!=null){
                minmax[0] = minmaxLeftSubtree[0];
            }else{
                minmax[0] = root.val;
            }
            if(root.right!=null){
                minmax[1] = minmaxRightSubtree[1];
            }else{
                minmax[1] = root.val;
            }
        }

        return 1;

    }

    public int isValidBST(TreeNode A) {

        return isValidBST(A,null);
    }
}



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
class Solution {
    public int isValidBST(TreeNode root) {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public int isBST(TreeNode root, int min, int max) {
        if (root == null) return 1;
        if (root.val < min || root.val > max) return 0;
        return Math.min(isBST(root.left, min, root.val - 1), isBST(root.right, root.val, max));
    }
}

