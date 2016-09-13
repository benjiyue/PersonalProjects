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
    int maxSum;
    public int maxPathSum(TreeNode root) {
        //idea is a bottom up approach and upon encounter of a node you either add one of left or right or neither to the node value, then return you own max value, also have a maxsum counter
        maxSum = Integer.MIN_VALUE;
        dfs(root);
        return maxSum;
    }
    
    public int dfs(TreeNode root){
        if(root==null)
            return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        
        int onlyIncludeLeft = left+root.val;//keep going
        int onlyIncludeRight = right+root.val;//keep going
        int includeOnlySelf = root.val;//did include me so keep going 
        
        int iAmInflection = root.val+left+right;
        
        int maxPossible = Math.max(Math.max(onlyIncludeLeft, onlyIncludeRight),includeOnlySelf);
        maxSum = Math.max(maxSum, Math.max(maxPossible, iAmInflection));
        return maxPossible>0?maxPossible:0;
    }
}