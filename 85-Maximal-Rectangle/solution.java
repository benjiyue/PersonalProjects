public class Solution {
    public int maximalRectangle(char[][] matrix) {
        //the idea is that when we only know when to do something when the thing in the stack stops at the current index with the current index being the higher right wall so we then extend the peeked thing back to the previous thing, but that means the thing in the stack must be the something even smaller height as that's how we'll know that it can no longer be extended, so the stack has only increasing heights
        
        //then if increase do calc then push to stack, else simply push
        
        //then at end the width for each is from the length-the current index, but if we ever see a 0 then the right becomes that index
        if(matrix.length==0||matrix[0].length==0)
            return 0;
        int[] heights = new int[matrix[0].length];
        int maxAreaEver = 0;
        for(int i=0;i<matrix.length;i++){
            updateHeight(heights, matrix, i);
            Stack<Integer> stack = new Stack();
            for(int a=0;a<heights.length;a++){
                //if im less then im termianting everyone who has come before who has higher height
                while(!stack.isEmpty()&&heights[a]<heights[stack.peek()]){
                    int prevHeight = heights[stack.pop()];
                    int width = stack.isEmpty()?a:a-stack.peek()-1;
                    maxAreaEver = Math.max(maxAreaEver, prevHeight*width);
                }
                stack.push(a);
            }
            
            while(!stack.isEmpty()){
                int index = stack.pop();
                int prevHeight = heights[index];
                int width = stack.isEmpty()?heights.length:heights.length-stack.peek()-1;
                maxAreaEver = Math.max(maxAreaEver, prevHeight*width);
            }
        }
        return maxAreaEver;
    }
    
    public void updateHeight(int[] heights, char[][] matrix, int level){
        for(int i=0;i<matrix[0].length;i++){
            int val = matrix[level][i]-'0';
            if(val==0){
                heights[i] = 0;
            }else
                heights[i]++;
        }
    }
}