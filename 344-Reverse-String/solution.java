public class Solution {
    public String reverseString(String s) {
        char[] c = s.toCharArray();
        for(int i=0;i<s.length()/2;i++){
            char temp = c[i];
            c[i] = c[s.length()-1-i];
            c[s.length()-1-i] = temp;
        }
        return new String(c);
    }
}