public class NumMatrix {
    int[][] sum;
    public NumMatrix(int[][] matrix) {
        //create a 2d array where each i,j index stores the sum of everything to the top left
        if(matrix.length==0||matrix[0].length==0)
            return;
        //sum across
        sum = new int[matrix.length][matrix[0].length];
        for(int i=0;i<sum.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                sum[i][j] = j-1<0?matrix[i][j]:matrix[i][j]+sum[i][j-1];
            }
        }
        //combine sums down
        for(int i=0;i<sum[0].length;i++){
            for(int j=1;j<matrix.length;j++){
                sum[j][i]+=sum[j-1][i];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int entire = sum[row2][col2];
        int topLeft = row1-1<0||col1-1<0?0:sum[row1-1][col1-1];
        int topRight = row1-1<0?0:sum[row1-1][col2];
        int bottomLeft = col1-1<0?0:sum[row2][col1-1];
        return entire+topLeft-topRight-bottomLeft;
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);