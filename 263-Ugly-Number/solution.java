public class Solution {
    public boolean isUgly(int num) {
        //keep dividing be 2,3,5 while the number is greater than the divisor then finally if it's 1 the it is ugle else it's not
        
        while(num>1&&num%2==0)
            num/=2;
        while(num>1&&num%3==0)
            num/=3;
        while(num>1&&num%5==0)
            num/=5;
        
        return num==1;
        
    }
}