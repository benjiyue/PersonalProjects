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
    we need two pointers to be keeping track of what to switch. and they're on the opposite sides of the tree. So we want to swap any two roots swap(TreeNode a, TreeNode b) we swap the values and then we send recursively a.left, b.right and a.right and b.left
    
     4
   /   \
  2     7    
 / \   / \
1   3 6   9
    
    */
    public TreeNode invertTree(TreeNode root) {
        if(root==null)
            return root;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}