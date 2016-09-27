public class Solution {
    public int addDigits(int num) {
        /*
        idea is to through each index starting from the lowest index and go left, we git the number by %10 then we /10 to get rid of it we also save the orig number if it happens at the end that the sum of all the digits is less than 10 then return the oring number else continue the loop
        
        11->2
        12->3
        55->10
        234->9
        
        */
        if(num==0)
            return 0;
        return num%9==0?9:num%9;
        
    }
}