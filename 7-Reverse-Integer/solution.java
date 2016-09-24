public class Solution {
    public int reverse(int x) {
        /*
        if it's negative just note that its negative and make it positive then make result negative
        we start at the right of a nubmer and mod 10 to get the lowest index, then multiply by 10 then increment by the modded value
        x   = 0
        res = -321
        */
        boolean isNeg = false;
        if(x<0){
            isNeg = true;
            x*=-1;
        }
        long res = 0;
        while(x>0){
            res*=10;
            res+=x%10;
            x/=10;
            if(res>Integer.MAX_VALUE)
                return 0;
        }
        return isNeg?(int)res*-1:(int)res;
    }
}