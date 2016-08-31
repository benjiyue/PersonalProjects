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
    List<Integer> res;
    Map<Integer, Integer> map;
    int maxDepth;
        
    public List<Integer> rightSideView(TreeNode root) {
        res = new ArrayList();
        if(root==null)
            return res;
        map = new HashMap();
        maxDepth = 0;
        rightSideView(root, 0);
        for(int i=0;i<=maxDepth;i++)
            res.add(map.get(i));
        return res;
    }
    
    public void rightSideView(TreeNode root, int depth){
        if(root==null)
            return;
        maxDepth = Math.max(maxDepth, depth);
        rightSideView(root.left, depth+1);
        map.put(depth, root.val);
        rightSideView(root.right, depth+1);
    }
}