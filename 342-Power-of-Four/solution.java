public class Solution {
    public boolean isPowerOfFour(int num) {
        if(num<=0)
            return false;
        //first we have to ensure the number is in odd positions (010101010101), we can and it with this odd indexed sequence and ensure that the answer is still the same otherwise it flipped a even index and for sure we know it's not a power of 4
        if((num|0x55555555)!=0x55555555)
            return false;
        
        return (num&(num-1))==0?true:false;
        
        //furthermore though not only does it have to be odd position, there can only be 1 set bit, so if we unset it the res should be 0, so if we do n&=-n and it equals 0 then yes else no
    }
}