public class Solution {
    public void rotate(int[][] matrix) {        
        if(matrix.length<2)
            return;
        
        for(int offset=0;offset<matrix.length/2;offset++){
            for(int j=0;j<matrix.length-1-2*offset;j++){
                int temp = matrix[offset][j+offset];
                //put the left to the top
                matrix[offset][offset+j] = matrix[matrix.length-1-offset-j][offset];
                //put the bottom to the left
                matrix[matrix.length-1-offset-j][offset] = matrix[matrix.length-1-offset][matrix.length-1-offset-j];
                //put the right to the bottom
                matrix[matrix.length-1-offset][matrix.length-1-offset-j] = matrix[offset+j][matrix.length-1-offset];
                //put the temp to the right
                matrix[offset+j][matrix.length-1-offset] = temp;
            }
        }
        
        
    }
}