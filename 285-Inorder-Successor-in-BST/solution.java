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
    
    //first find the value then ask if it has right nodes if it does then the next highest will comde from there, otherwise the value will come from the first thing along the way back if you're coming from left
    
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root==p){
            TreeNode iter = root.right;
            if(iter!=null){
                while(iter!=null&&iter.left!=null)
                    iter = iter.left;
                return iter;
            }else
                return null;
        }else{
            if(p.val>root.val){
                return inorderSuccessor(root.right, p);
            }
            //root is greater than the p, so i went left, so you're coming from the left
            else{
                TreeNode returned = inorderSuccessor(root.left, p);
                return returned!=null?returned:root;
            }
        }
    }
}