public class Solution {
    /*
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
    */
    public boolean searchMatrix(int[][] matrix, int target) {
        /*
        idea is to start with using the rightmost element of the row, if larger go down. if smaller go left
        if out of bounds return else if found return true
        */
        
        int row = 0;
        int col = matrix[0].length-1;
        
        while(row<matrix.length&&col>=0){
            if(matrix[row][col]==target)
                return true;
            if(target>matrix[row][col])
                row++;
            else
                col--;
        }
        return false;
    }
}