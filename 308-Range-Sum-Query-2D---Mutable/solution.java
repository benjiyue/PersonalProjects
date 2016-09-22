public class NumMatrix {
    //the ide is to use a binary index tree with 2d indexing
    //so first 
    int[][] bit;
    int[][] val;
    public NumMatrix(int[][] matrix) {
        if(matrix.length==0||matrix[0].length==0)
            return;
        bit = new int[matrix.length+1][matrix[0].length+1];
        val = new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                update(i,j,matrix[i][j]);
            }
        }
    }

    public void update(int row, int col, int newVal) {
        int diff = newVal-val[row][col];
        val[row][col] = newVal;
        row++;
        col++;
        while(row<bit.length){
            int tempCol = col;
            while(tempCol<bit[0].length){
                bit[row][tempCol]+=diff;
                tempCol+=tempCol&(-tempCol);
            }
            row+=row&(-row);
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int total = sum(row2, col2);
        int topLeft = (row1-1<0||col1-1<0)?0:sum(row1-1, col1-1);
        int bottomLeft = col1-1<0?0:sum(row2, col1-1);
        int topRight = row1-1<0?0:sum(row1-1, col2);
        
        return total-bottomLeft-topRight+topLeft;
    }
    
    public int sum(int row, int col){
        int sum=0;
        row++;
        col++;
        while(row>0){
            int tempCol = col;
            while(tempCol>0){
                sum+=bit[row][tempCol];
                tempCol-=tempCol&(-tempCol);
            }
            row-=row&(-row);
        }
        return sum;
    }
    
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.update(1, 1, 10);
// numMatrix.sumRegion(1, 2, 3, 4);