public class Solution {
    public void setZeroes(int[][] matrix) {
        /*
        the idea is that we iterate over the matrix and if we encounter a 0 we set it's appropriate row and column to 0, the only problem is with 0,0 and we'll let that represent the row and have an auxillary boolean indicating whether the 0 column should be made 0
        */
        
        int zeroCol = 1;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    if(j==0){
                        zeroCol = 0;
                    }else
                        matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        
        //invalidate rows
        for(int i=1;i<matrix.length;i++){
            if(matrix[i][0]==0){
                for(int a=0;a<matrix[0].length;a++)
                    matrix[i][a] = 0;
            }
        }
        int origFirstRow = matrix[0][0];
        for(int i=0;i<matrix[0].length;i++){
            if((i==0&&zeroCol==0)||(i!=0&&matrix[0][i]==0)){
                for(int a=0;a<matrix.length;a++)
                    matrix[a][i] = 0;
            }
        }
        
        //invalidate frst row
        if(origFirstRow==0){
            for(int j=0;j<matrix[0].length;j++)
                matrix[0][j] = 0;
        }
        
        /*
        zeroCol = 0
[1,1,1]
[0,0,0]
        */
    }
}