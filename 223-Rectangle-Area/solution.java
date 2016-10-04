public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int totalArea = (D-B)*(C-A)+(H-F)*(G-E);
        
        //they're distinct if the bottomLe of one is greater than the top of other or if the right is less than the left of other 
        
        if(B>=H||D<=F||A>=G||C<=E)
            return totalArea;
        
        int maxLeft = Math.max(A,E);
        int minRight = Math.min(C,G);
        int maxBottom = Math.max(B,F);
        int minTop = Math.min(D,H);
        
        return totalArea-(minRight-maxLeft)*(minTop-maxBottom);
    }
}