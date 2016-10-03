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
    public boolean isSymmetric(TreeNode root) {
        /*
        the idea is that at each point we have to ensure that the left's.left matches the right's.right and left's.right matches right's.left
        */
        
        if(root==null)
            return true;
        
        return isMatch(root.left, root.right);
    }
    
    public boolean isMatch(TreeNode left, TreeNode right){
        if(left==null&&right==null)
            return true;
        if(left==null||right==null)
            return false;
        
        if(left.val!=right.val)
            return false;
        
        if(!isMatch(left.right, right.left)||!isMatch(left.left, right.right))
            return false;
        return true;
    }
}