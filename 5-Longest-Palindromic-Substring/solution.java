public class Solution {
    String longest;
    public String longestPalindrome(String s) {
        /*
        idea is to anchor each start point at any possible start point and keep expanding, it can also be 2 things in the mid so we also have to take care of that, and from the mid point we keep expanding both pointers out
        
        */
        longest = "";
        if(s==null||s.length()==0)
            return "";
        for(int i=0;i<s.length();i++){
            findLongest(i,i,s);
            findLongest(i, i+1, s);
        }
        return longest;
    }
    
    public void findLongest(int i, int j, String s){
        while(i>=0&&j<s.length()){
            if(s.charAt(i)==s.charAt(j)){
                i--;
                j++;
            }else
                break;
        }
        if(j-i-1>longest.length()){
            longest = s.substring(i+1, j);
        }
    }
    

}