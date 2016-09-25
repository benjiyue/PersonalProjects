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
    int maxDepth;
    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        maxDepth = 1;
        dfs(root, 1);
        return maxDepth;
    }
    /*
            5
        3       0
              1
    
    */
    
    public void dfs(TreeNode root, int level){
        if(root==null)
            return;
        
        maxDepth = Math.max(level, maxDepth);
        dfs(root.left, level+1);
        dfs(root.right, level+1);
    }
}