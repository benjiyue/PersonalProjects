public class Solution {
    public String countAndSay(int n) {
        /*
        so the idea is that we start from 1 and iterate up each time we use a counter which counts the number of the current item and a pointer to the current thing we're looking at .when the next thing is the same we move the pointer up and icnrement count, when this condition breaks we add the count and the variable to the string and move up the pointer and reset counter to 0
        */
        if(n==1)
            return "1";
            
        String prev = "1";
        n--;
        while(n>0){
            StringBuilder next = new StringBuilder();
            for(int i=0;i<prev.length();){
                char c = prev.charAt(i);
                int iter = i;
                while(iter<prev.length()&&prev.charAt(iter)==c)
                    iter++;
                next.append(iter-i);
                i = iter;
                next.append(c);
            }
            prev = next.toString();
            n--;
        }
        return prev;
    }
}