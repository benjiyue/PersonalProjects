public class Solution {
    public double myPow(double x, int n) {
        /*
        x^n. the idea is that if I can decrease n by powers of 2 every time then i can make the runtime log
        for each time if n is divisible by 2 then the result is the pow(x*x,n/2) else if it's mid= 1 then x*pow(x*x,n/2)
        */
        
        if(n<0){
            x = 1/x;
            if(n==Integer.MIN_VALUE)
                n = Integer.MAX_VALUE-1;
            else
                n*=-1;
        }
        
        if(n==0)
            return 1;
        if(n==1)
            return x;
        if(n%2==0)
            return myPow(x*x, n/2);
        else
            return x*myPow(x*x, n/2);
        
    }
}