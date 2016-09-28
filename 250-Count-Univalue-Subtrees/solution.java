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
    the idea is ops order traversal. all the leaves return 1 because those are univalue subtrees
    
    then if left and right are not 0 and lef val and right valare eal to root return left+right+1
    else if one is 0 return the match with the one that is valid
    
            -15
             / \
          -151   5
           / \   \
         150  5   5
         /
        2
    count = 2
    */
    int count;
    public int countUnivalSubtrees(TreeNode root) {
        if(root==null)
            return 0;
        count = 0;
        int res=dfs(root);
        if(res>0)
            count++;
        return count;
    }
    
    public int dfs(TreeNode root) {
        if(root==null)
            return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        if(left>0)  count++;
        if(right>0) count++;
        if(left<0||right<0) return -1;
        boolean thisToo = true;
        if(root.left!=null&&root.left.val!=root.val)
            thisToo = false;
        if(root.right!=null&&root.right.val!=root.val)
            thisToo = false;
        if(thisToo)
            return 1;
        else
            return -1;
    }
}