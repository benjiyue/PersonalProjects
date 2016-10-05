public class Solution {
    public int maximalRectangle(char[][] matrix) {
        /*
        the biggest rectangle in a histogram
        nm
        
        max = 6
        
        stack:3,6
        
        oo  oo
        ooo oo
        ooooooo
        0123456
        how to find the largest rectangle in a histogram
        
        we use a atack to push if empty or if the current height increases. we pop off while the current thing is less than the peek height and the length that that thing couldve extended is equal to the peek position and the current iterator position
        max = 7
        */
        
        if(matrix.length==0||matrix[0].length==0)
            return 0;
        
        int maxEver = 0;
        
        int[] heights = new int[matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            updateHeight(heights, matrix, i);
            Stack<Integer> stack = new Stack();
            int iter = 0;
            while(iter<heights.length){
                if(stack.isEmpty()||heights[iter]>=heights[stack.peek()]){
                    stack.push(iter++);
                }else{
                    int pos = stack.pop();
                    int height = heights[pos];
                    int width = stack.isEmpty()?iter:iter-stack.peek()-1;//HERE, if the stack is empty then it extends from current iterator to the beginning
                    maxEver = Math.max(maxEver, height*width);
                }
            }
            while(!stack.isEmpty()){
                int pos = stack.pop();
                int height = heights[pos];
                int width = stack.isEmpty()?heights.length:heights.length-1-stack.peek();//HERE, it extends from the end to the beginning if thr stack is empty because 
                maxEver = Math.max(maxEver, height*width);
            }
            //pop off everything
        }
        
        return maxEver;
        
    }
    
    //updates the heighy using the row in matrix
    public void updateHeight(int[] height, char[][] matrix, int row){
        for(int i=0;i<matrix[0].length;i++){
            if(matrix[row][i]=='0')
                height[i] = 0;
            else
                height[i]++;
        }
    }
}