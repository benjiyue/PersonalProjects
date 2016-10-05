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
    public List<List<Integer>> levelOrder(TreeNode root) {
        /*
        we can do a in order traversal keeping track of the current depth and add to the arrsylist position at that depth the current node value. and if the current depth is out of bounds then it means it's the next index so add to list and put it to the position
        */
        
        List<List<Integer>> res = new ArrayList();
        dfs(root, 0, res);
        return res;
    }
    
    public void dfs(TreeNode root, int depth, List<List<Integer>> res){
        if(root==null)
            return;
        
        if(depth>=res.size()){
            res.add(new ArrayList<Integer>());
        }
        res.get(depth).add(root.val);
        dfs(root.left, depth+1, res);
        dfs(root.right, depth+1, res);
    }
}