public class Solution {
    public List<List<String>> solveNQueens(int n) {
        /*
        iterate on the row, have column boolean array
        have upRight has index col-row , and upLeft 2*length boolean array with index sum of the two
        */
        res = new LinkedList();
        this.n = n;
        board = new boolean[n][n];
        cols = new boolean[n];
        //diff the two
        upLeft = new boolean[2*n];
        //sum the two
        upRight = new boolean[2*n];
        dfs(0, 0);
        return res;
    }
    List<List<String>> res;
    int n;
    boolean[][] board;
    boolean[] cols;
    boolean[] upLeft;
    boolean[] upRight;
    
    public void dfs(int row, int counter){
        if(counter==n){
            addString();
            return;
        }
        for(int a = 0;a<n;a++){
            if(!cols[a]&&!upLeft[a-row+n-1]&&!upRight[row+a]){
                cols[a]=upLeft[a-row+n-1]=upRight[row+a] = true;
                board[row][a] = true;
                dfs(row+1, counter+1);
                board[row][a] = false;
                cols[a]=upLeft[a-row+n-1]=upRight[row+a] = false;
            }
        }
    }
    
    public void addString(){
        List<String> thisRes = new LinkedList();
        for(int i=0;i<n;i++){
            StringBuilder cur = new StringBuilder();
            for(int j=0;j<n;j++){
                if(board[i][j]){
                    cur.append('Q');
                }else
                    cur.append('.');
            }
            thisRes.add(cur.toString());
        }
        res.add(thisRes);
    }
}