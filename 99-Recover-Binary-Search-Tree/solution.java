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
    
    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = new TreeNode(Integer.MIN_VALUE);
    
    public void recoverTree(TreeNode root) {
        //in order traversal:
        //always keep track of what lok at before if im less than what i looked at before abnd the first placeholder is null then the prev is the first
        
        //if i am less than the thing before me then im the second
        
        first = null;
        second = null;
        prev = new TreeNode(Integer.MIN_VALUE);
        inOrder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    
    public void inOrder(TreeNode root){
        if(root==null)
            return;
        
        inOrder(root.left);
        
        if(root.val<prev.val&&first==null)
            first = prev;
        if(root.val<prev.val&&first!=null)
            second = root;
            
        prev = root;
        
        inOrder(root.right);
    }
    
    
}