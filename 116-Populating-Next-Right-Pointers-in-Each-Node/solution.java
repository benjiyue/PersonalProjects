/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        /*
        bfs, except you have to set up the next level before you go there using an auxillary pointer. 
        you go through each thing i nthe current level and for each you ask if the current thing has a left and right pointer. if it does then you visit it in that order and move up the iterator for the next level. Then when you reach the end of the current level you set the begin of the level to the dummy.next to initialize the start of the next level
        */
        
        if(root==null)
            return;
        
        TreeLinkNode nextLevelDummy = new TreeLinkNode(-1);
        TreeLinkNode curLevel = root;
        
        while(curLevel!=null){
            TreeLinkNode nextLevelPrev = nextLevelDummy;
            while(curLevel!=null){
                if(curLevel.left!=null){
                    nextLevelPrev.next = curLevel.left;
                    nextLevelPrev = nextLevelPrev.next;
                }
                if(curLevel.right!=null){
                    nextLevelPrev.next = curLevel.right;
                    nextLevelPrev = nextLevelPrev.next;
                }
                curLevel = curLevel.next;
            }
            curLevel = nextLevelDummy.next;
            nextLevelDummy.next = null;
        }
        
    }
}