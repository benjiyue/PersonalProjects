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
    int maxEver;
    public int maxPathSum(TreeNode root) {
        
        /*postorder traversal
                    10
                3(3)       -7(1)
            -99(0)              8(8)
        1(1)
        maxEver = 14
        maxToREturn = 3;
        */
        
        if(root==null)
            return 0;
        
        maxEver = root.val;
        postOrder(root);
        return maxEver;
    }
    
    public int postOrder(TreeNode root){
        if(root==null)
            return 0;
        
        int left = postOrder(root.left);
        int right = postOrder(root.right);
        
        int maxToReturn = Math.max(root.val+left, Math.max(root.val+right,root.val));
        int maxValue = Math.max(maxToReturn, left+right+root.val);
        maxEver = Math.max(maxValue, maxEver);
        return maxToReturn<0?0:maxToReturn;
    }
}