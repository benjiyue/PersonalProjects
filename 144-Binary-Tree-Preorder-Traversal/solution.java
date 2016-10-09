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
    public List<Integer> preorderTraversal(TreeNode root) {
        /*
        we use a stack. at first we try going as left as possible from the root node and we put the thing to the res as we visit, then while the stack isn't empty we pop off, go right, visit and try going as left as possible while visiting and adding to res
   1
 /  \
2    2
    /
   3
   res:1->2->3
   stack:2,3
   
        */
        List<Integer> res = new LinkedList();
        if(root==null)
            return res;
        Stack<TreeNode> stack = new Stack();
        while(root!=null){
            stack.push(root);
            res.add(root.val);
            root = root.left;
        }
        while(!stack.isEmpty()){
            TreeNode popped = stack.pop();
            popped = popped.right;
            while(popped!=null){
                stack.push(popped);
                res.add(popped.val);
                popped = popped.left;
            }
        }
        return res;
        
    }
}