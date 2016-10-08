/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void flatten(TreeNode root) {
        //we flatten by making the .right equal to the .left, but we have to first save the .right then insert the .left if it's non null then go all the way to the right then put the last thing to the saved next
        
        if(root==null)
            return;
        
        postOrder(root);
    }
    
    public TreeNode postOrder(TreeNode root){
        if(root==null)
            return null;
        
        TreeNode left = postOrder(root.left);
        TreeNode right = postOrder(root.right);
        
        if(left!=null){
            root.left = null;
            TreeNode next = root.right;
            root.right = left;
            while(left.right!=null)
                left = left.right;
            left.right = next;
        }
        return root;
        
    }
}