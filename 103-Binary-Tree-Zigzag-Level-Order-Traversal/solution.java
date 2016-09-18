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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        //do a in order traversal of the tree and add each node to the level, then iterate over it and reverse the odd positions
        List<List<Integer>> res = new ArrayList();
        //if the list doesn't have that depth add it to the next position because you will always be increasing level by 1 so if you haven;t seen it then for sure it's 1 more
        if(root==null)
            return res;
            
        inOrder(root, res, 0);
        int counter = 0;
        for(List<Integer> i:res){
            if(counter++%2==1){
                Collections.reverse(i);
            }
        }
        return res;
    }
    public void inOrder(TreeNode root, List<List<Integer>> res, int level){
        if(root==null)
            return;
        if(res.size()<=level){
            res.add(new LinkedList<Integer>());
        }
        inOrder(root.left, res, level+1);
        
        res.get(level).add(root.val);
        
        inOrder(root.right, res, level+1);
    }
}