public class Solution {
    public char findTheDifference(String s, String t) {
        //map the characters to the counts and then find the count that has a difference
        int[] count = new int[26];
        for(int i=0;i<s.length();i++)
            count[s.charAt(i)-'a']++;
        for(int i=0;i<t.length();i++){
            if(count[t.charAt(i)-'a']--==0)
                return t.charAt(i);
        }
        return ' ';
    }
}