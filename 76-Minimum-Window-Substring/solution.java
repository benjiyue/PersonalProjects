public class Solution {
    public String minWindow(String s, String t) {
        int[] count = new int[256];
        int uniques = 0;
        for(int i=0;i<t.length();i++){
            if(count[t.charAt(i)]++==0)
                uniques++;
        }
        
        int left= 0;
        int right = 0;
        
        int minStart = -1;
        int minLen = s.length();
        
        while(right<s.length()){
            if(count[s.charAt(right++)]--==1)
                uniques--;
                
            while(uniques==0){
                if(right-left<=minLen){
                    minStart = left;
                    minLen = right-left;
                }
                if(count[s.charAt(left++)]++==0)
                    uniques++;
            }
        }
        return minStart==-1?"":s.substring(minStart,minStart+minLen);
    }
}