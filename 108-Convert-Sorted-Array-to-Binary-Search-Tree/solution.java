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
    we have a sorted list, get the root by getting the n/2 node then adjust the range to 0->n/2-1 for left and n/2+1,n for right, then recurssively build the tree and return the root node for that level
    */
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums==null||nums.length==0)
            return null;
        return bs(nums, 0, nums.length-1);
    }
    /*
          l
          h
        m
    1,2,3,4
    
    2
1       3 
          4
    */
    public TreeNode bs(int[] nums, int low, int high){
        if(low>high)
            return null;
        
        if(low==high)
            return new TreeNode(nums[low]);
        int mid = (low+high)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = bs(nums, low, mid-1);
        root.right = bs(nums, mid+1, high);
        return root;
    }
}