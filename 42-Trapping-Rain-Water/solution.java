public class Solution {
    public int trap(int[] height) {
        //the idea is that we iterate left to right on the array along with a stack, if the current index is less than or equal to the previous height then insert it into the stack ,otherwise the current thing is the right wall and we poll from the stack. The height is the min of the left or right of the popped and the distance is the width
        
        if(height==null||height.length<3)
            return 0;
        int totalArea = 0;
        Stack<Integer> stack = new Stack();
        int current = 0;
        //why less than or equal to?
        while(current<height.length){
            if(stack.isEmpty()||height[current]<=height[stack.peek()])
                stack.push(current++);
            else{
                int poppedIndex = stack.pop();
                int area = stack.isEmpty()?0:
                (Math.min(height[current], height[stack.peek()])-height[poppedIndex])*(current-stack.peek()-1);
                totalArea += area;
            }
        }
        //why no need to pop off remainder?
        return totalArea;
    }
}