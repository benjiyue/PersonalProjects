public class Solution {
    public int trap(int[] height) {

        if(height.length<3)
            return 0;
        int area = 0;
        Stack<Integer> stack = new Stack();
        int counter = 0;
        while(counter<height.length){
            if(stack.isEmpty()||height[counter]<height[stack.peek()])
                stack.push(counter++);
            //stack is greater than or equal to peek
            else{
                int poppedIndex = stack.pop();
                int floorHeight = height[poppedIndex];
                if(stack.isEmpty())
                    continue;
                int leftWallHeight = height[stack.peek()];
                int min = Math.min(height[counter], leftWallHeight);
                int diff = min-floorHeight;
                area+=diff*(counter-stack.peek()-1);
            }
        }
        return area;
    }
}