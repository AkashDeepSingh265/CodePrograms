//package BinarySearch;
//
//public class BSTIterator {
//
//    Stack<TreeNode> stack = null;
//    TreeNode current = null;
//    public Solution(TreeNode root) {
//        this.current = root;
//        this.stack = new Stack<TreeNode>();
//    }
//
//    /** @return whether we have a next smallest number */
//    public boolean hasNext() {
//        return (!this.stack.isEmpty() || this.current !=null);
//    }
//
//    /** @return the next smallest number */
//    public int next() {
//        while(this.current !=null){
//            this.stack.push(this.current);
//            this.current = this.current.left;
//        }
//        TreeNode node = this.stack.pop();
//        this.current = node.right;
//        return node.val;
//    }
//}
//
///**
// * Your Solution will be called like this:
// * Solution i = new Solution(root);
// * while (i.hasNext()) System.out.print(i.next());
// */
//
