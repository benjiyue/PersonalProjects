public class Solution {
    public int uniquePaths(int m, int n) {
        
        if(m==0||n==0)
            return 0;
        
        int[] paths = new int[n];
        for(int i=0;i<paths.length;i++)
            paths[i] = 1;
        
        for(int i=1;i<m;i++){
            int[] thisLevel = new int[n];
            thisLevel[0] = 1;
            for(int j=1;j<n;j++){
                thisLevel[j] = paths[j]+thisLevel[j-1];
            }
            paths = thisLevel;
        }
        
        return paths[n-1];
    }
}