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
    public boolean hasPathSum(TreeNode root, int sum) {
        
        if(root==null)
            return false;
            
        return dfs(root, sum);
        
        
    }
    
    public boolean dfs(TreeNode root, int sum){
        if(root==null)
            return false;
        if(root.left==null&&root.right==null){
            return sum==root.val;
        }
        
        if(dfs(root.left, sum-root.val)||dfs(root.right, sum-root.val))
            return true;
        return false;
    }
}