public class Solution {
    public boolean isPalindrome(int x) {
        /*
        find the leftmost set digit by continuing to divide by powers of 10 and the leftmost position which wasn't 0 is the solution, then multiply the lower 10 power by 10 each time and decrease the higher by 10 each time and compare the division values if they're different it's not  palindrome
            power = 1000
            highestPower = 10
            lowestPower = 100
            1001
        */
        
        if(x<0)
            return false;
        
        int power = 1;
        int highestPower = 1;
        while(power<=1000000000){
            if(x/power>0)
                highestPower = power;
            if(power==1000000000)
                break;
            power*=10;
        }
        
        int lowestPower = 1;
        while(highestPower>lowestPower){
            int left = (x/highestPower)%10;
            int right = (x/lowestPower)%10;
            if(left!=right)
                return false;
            highestPower/=10;
            lowestPower*=10;
        }
        return true;
    }
}