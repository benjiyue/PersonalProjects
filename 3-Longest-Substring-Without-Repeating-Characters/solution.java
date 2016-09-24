public class Solution {
    public int lengthOfLongestSubstring(String s) {
        /*
        idea is sliding window where we keep a count of the number of characters, when we move the right pointer and it already has been visited then we fist update the max length of the result then include this character count. Then start sliding the left window until you get to the thing that has count 2 which means you decrement it and set the left pointer here, then start increasing the right pointer
        */
        
        if(s==null||s.length()==0)
            return 0;
        /*
            l
               r
        "pwwkew"
         012345
        p = 0
        w = 1
        k = 1
        e = 1
        max = 2
        */
        int left = 0;
        int right = 0;
        int[] count = new int[256];
        int maxLen = 0;
        while(right<s.length()){
            char c = s.charAt(right);
            //start sliding the left window beause we've already seen this character before
            if(count[c]++==1){
                maxLen = Math.max(maxLen, right-left);
                //keep sliding the left pointer until we get to the 
                while(true){
                    if(count[s.charAt(left++)]--==2)
                        break;
                }
            }
            right++;
        }
        //do a final check
        maxLen = Math.max(maxLen, right-left);
        return maxLen;
    }
}