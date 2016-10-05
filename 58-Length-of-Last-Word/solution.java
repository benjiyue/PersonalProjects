public class Solution {
    public int lengthOfLastWord(String s) {
        /*
        we first trim the edges by not considering while the pointer is at a ' ' char if this goes to -1 then return 0
        we iterate from the last actual character index going towards the left. until we encounter another space then it's right-left
            r
          l
         012345
        "a bc   "
        
        */
        
        int lastChar = s.length()-1;
        while(lastChar>=0&&s.charAt(lastChar)==' ')
            lastChar--;
        
        if(lastChar==-1)
            return 0;
            
        int left = lastChar;
        while(left>=0&&s.charAt(left)!=' '){
            left--;
        }
        
        return lastChar-left;
        
    }
}