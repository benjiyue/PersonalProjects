public class Solution {
    public int titleToNumber(String s) {
        int sum = 0;
        for(int i=0;i<s.length();i++){
            sum*=26;
            sum+=s.charAt(i)+1-'A';
        }
        return sum;
    }
}