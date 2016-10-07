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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /*
        look in the l and r subtree of root for p and q and if one comes from lefr and the other comes from right then im the final result, else if both come from one direction then simply return what was returned
        */
        
        res = null;
        dfs(root, p, q);
        return res;
    }
    TreeNode res;
    /*
        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6       2       0       8
         /  \
         7   4
         */
    public int dfs(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)
            return 0;
        
        int left = dfs(root.left, p, q);
        int right = dfs(root.right, p, q);
        if(left==1&&right==1){
            res = root;
            return 2;
        }
        if((root==p||root==q)&&(left==1||right==1)){
            res = root;
            return 2;
        }
        if(root==p||root==q)
            return 1;
        return left+right;
    }
    
}