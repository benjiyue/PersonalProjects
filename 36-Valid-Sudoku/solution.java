public class Solution {
    public boolean isValidSudoku(char[][] board) {
        //we have a 2d array of size 9x9 the row represents the row,column, chunk and the columns represent the values already already at that position, if ever we encounter a position where any of the 3 things are filled then we return false
        
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] chunks = new boolean[9][9];
        
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!='.'){
                    int num = board[i][j]-'1';
                    if(rows[i][num]||cols[j][num]||chunks[(i/3)*3+j/3][num])
                        return false;
                    rows[i][num]=cols[j][num]=chunks[(i/3)*3+j/3][num] = true;
                        
                }
            }
        }
        return true;
    }
}