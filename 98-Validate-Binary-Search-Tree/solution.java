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
    public boolean isValidBST(TreeNode root) {
        /*
        the idea is that we pass down to each level the range that's allowed for that node and if it breaks it then return false, else keep going down the tree and cut range into 2 parts left:[low,val-1] and right:[val+1, right]
        
            -2b(-2b,2b)
        -2b(-2b,-2b-1)        2b()
        
        */
        if(root==null)
            return true;
        
        long low = Integer.MIN_VALUE;
        long high = Integer.MAX_VALUE;
        return dfs(root, low, high);
    }
    
    public boolean dfs(TreeNode root, long low, long high){
        if(root==null)
            return true;
        
        if(root.val>high||root.val<low||(low>high))
            return false;
        
        if(!dfs(root.left, low, (long)root.val-1)||!dfs(root.right, (long)root.val+1, high))
            return false;
        
        return true;
        
    }
    
}