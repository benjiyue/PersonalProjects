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
    int res;
    public int minDepth(TreeNode root) {
        if(root==null)
            return 0;
        res = Integer.MAX_VALUE;
        dfs(root, 1);
        return res;
    }
    
    public void dfs(TreeNode root, int depth){
                /*
        we do a dfs down to a leaf node and return 1 if left and right is null then at each step we go back return the min of left and right
        */
        if(root==null){
            return;
        }
        if(root.left==null&&root.right==null){
            res = Math.min(res, depth);
            return;
        }
        dfs(root.left, depth+1);
        dfs(root.right, depth+1);
    }
    /*
            5
        3       4
          4       6
                    7
    
    */
}