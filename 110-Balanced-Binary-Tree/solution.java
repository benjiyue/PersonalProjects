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
    /*
        5
      3   1
     1
    2    
    */
    public boolean isBalanced(TreeNode root) {
        if(root==null)
            return true;
        isBalanced = true;
        dfs(root);
        return isBalanced;
    }
    private boolean isBalanced;
    
    public int dfs(TreeNode root){
        if(root==null)
            return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        if(Math.abs(left-right)>1)
            isBalanced = false;
        return Math.max(left, right)+1;
    }
}