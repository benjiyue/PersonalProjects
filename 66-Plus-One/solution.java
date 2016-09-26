public class Solution {
    public int[] plusOne(int[] digits) {
        /*
        we iterate from the right/end to the left. first increment the last index. we assign the value to be val%10 and carry over to the left val/10;
        if there is a carry on the the 0th index we have to increase the size by 1 and then copy the array with a 1 prependede and the 0th position modded by 10
          i
        [0,0]
        [1,0,0]
        */
        
        if(digits==null||digits.length<1)
            return digits;
        
        digits[digits.length-1]++;
        for(int i=digits.length-1;i>0;i--){
            digits[i-1]+=digits[i]/10;
            digits[i]%=10;
        }
        if(digits[0]>=10){
            int[] res = new int[digits.length+1];
            res[0] = 1;
            digits[0]%=10;
            for(int i=0;i<digits.length;i++)
                res[i+1] = digits[i];
            return res;
        }
        return digits;
    }
}