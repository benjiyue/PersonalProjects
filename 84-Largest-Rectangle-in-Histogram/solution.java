public class Solution {
    public int largestRectangleArea(int[] heights) {
        //when increase or equal simply than peek push, when less than pop because you're saying that the popped element hight can no longer extend because im shorted than it so it ends with height and the difth equal to left and right, and because the invariant was that things in the stack were increasing then for sure the peek would too be lower
        
        if(heights.length==0)
            return 0;
        
        Stack<Integer> stack = new Stack();
        int counter = 0;
        int maxArea = 0;
        while(counter<heights.length){
            if(stack.isEmpty()||heights[stack.peek()]<=heights[counter])
                stack.push(counter++);
            else{
                int poppedIndex = stack.pop();
                int poppedHeight = heights[poppedIndex];
                int area = stack.isEmpty()?(counter)*poppedHeight:(counter-stack.peek()-1)*poppedHeight;
                maxArea = Math.max(area, maxArea);
            }
        }
        
        while(!stack.isEmpty()){
            int poppedIndex = stack.pop();
            int poppedHeight = heights[poppedIndex];
            int area = stack.isEmpty()?heights.length*poppedHeight:(heights.length-stack.peek()-1)*poppedHeight;
            maxArea = Math.max(area, maxArea);
        }
        
        return maxArea;
    }
}