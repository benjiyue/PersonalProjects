public class Solution {
    public boolean canWinNim(int n) {
        /*idea is that if the number of pieces is a multiple of 4 then no matter what i pick he will have last shot and same for anything else that's a multiple of 4 whatever i pick he will pick a value to bring the value again to a multiple of 4, and eventually i have to go first on 4 and then i'll lose
        
        */
        return !(n%4==0);
    }
}