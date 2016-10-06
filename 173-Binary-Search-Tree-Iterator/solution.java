/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    /*
    
            5
        3       7
    2      4       
    stack:
    res:2,3,4,5,7
    we use a stack to hold the in order traversal we have a next as long as there's soemthing in the stack.
    each time we pop form the stack we try to go as far left as possible. Next pops from the stack and then goes right, then while the left is not null we push onto the stack
    
    */
    
    Stack<TreeNode> stack;
    
    public BSTIterator(TreeNode root) {
        stack = new Stack();
        while(root!=null){
            stack.push(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode popped = stack.pop();
        int toRet = popped.val;
        popped = popped.right;
        while(popped!=null){
            stack.push(popped);
            popped = popped.left;
        }
        return toRet;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */