public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        //idea is sliding window. You side the right and have a counter for the number of new characters you've seen for the first time if it's already 2 and you increment something that's never seen before, you get the length between here and left anchor then you keep sliding the left anchor until it goes to 0 then stop
        
        int maxLen = 0;
        int left = 0;
        int right = 0;
        int[] count = new int[256];
        int uniques = 0;
        while(right<s.length()){
            int currentCount = count[s.charAt(right)];
            //this is another character i dont want to add. i want to slide and get the min
            if(currentCount==0&&uniques==2){
                maxLen = Math.max(right-left, maxLen);
                while(uniques==2){
                    if(count[s.charAt(left++)]--==1)
                        uniques--;
                }
            }else if(currentCount==0){
                uniques++;
                count[s.charAt(right)]++;
                right++;
            }else{
                count[s.charAt(right)]++; 
                right++;
            }
        }
        //check last time
        maxLen = Math.max(right-left, maxLen);
        return maxLen;
        /*
          l
               r
        eceaaaa
          234567
        count:e=1, c=0, a=4
        unqiues:2
        */
    }
}