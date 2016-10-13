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
    public List<Integer> inorderTraversal(TreeNode root) {
        /*idea is to use a stack
        i will first try to go left as much as possible
        then whenever you pop from the stack you visit that node and add to the output array
        then you go right on if if possible and go as left as possible and push into the stack
        */
        
        Stack<TreeNode> stack = new Stack();
        while(root!=null){
            stack.push(root);
            root = root.left;
        }
        
        List<Integer> res = new LinkedList();
        
        while(!stack.isEmpty()){
            TreeNode popped = stack.pop();
            res.add(popped.val);
            popped = popped.right;
            while(popped!=null){
                stack.push(popped);
                popped = popped.left;
            }
        }
        return res;
    }
}