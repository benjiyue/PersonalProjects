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
    public List<Integer> postorderTraversal(TreeNode root) {
        //two stack approach, one in which we use to iterate and another we use to hold the answer except it's in reversed order and the reason it works is because we only visit the actual node after its entire subtrees have been visited, so thats why we can push the node immediately into the stack because in reversed order it will actually be the last thing visited after all the subnodes, then we push left then right, because we want to poll the right next because just before going back to the orogin we visit the immediate right node so that's why to have the right node immediately before the root in reversed order, we have to push it into the result array now.
        Stack<TreeNode> processing = new Stack();
        List<Integer> result = new ArrayList<Integer>();
        if(root==null)
            return result;
        processing.add(root);
        while(!processing.isEmpty()){
            root = processing.pop();
            result.add(root.val);
            if(root.left!=null)
                processing.push(root.left);
            if(root.right!=null)
                processing.push(root.right);
        }
        Collections.reverse(result);
        return result;
    }
}