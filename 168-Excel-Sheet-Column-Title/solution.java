public class Solution {
    public String convertToTitle(int n) {
        //you
        StringBuilder res = new StringBuilder();
        while(n>0){
            n--;
            char nextChar = (char) ((n%26)+'A');
            res.append(nextChar);
            n/=26;
        }
        res.reverse();
        return res.toString();
    }
}