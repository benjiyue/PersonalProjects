public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        /*
        we need to look at each bit of the number and reverse it by asking if it is a 1 then |=1 with the to return integer, else do nothing. but in either case we <<1 to shift it up
        
        
        10001
        */
        int res = 0;
        for(int i=0;i<32;i++){
            if((n&1)==1){
                res|=1;
            }
            n>>=1;
            if(i==31)
                break;
            res<<=1;
        }
        return res;
    }
}