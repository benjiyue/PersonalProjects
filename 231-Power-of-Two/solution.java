public class Solution {
    
    public boolean isPowerOfTwo(int n) {
        
        if(n==0)
            return false;
        
        /*
        only one bit is set and everhting else is not set
        */
        int set = 0;
        while(n>0){
            if((n&1)==1)
                set++;
            n>>=1;
        }
        return set==1;
    }
}