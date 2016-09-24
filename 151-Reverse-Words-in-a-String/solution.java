public class Solution {
    public String reverseWords(String s) {
        /*
        idea is to start from the end of the array and go left until you meet a space then take the index of the last anchor and the current string and add the substring to the result builder then se anchor to current pos-1 since it's a space
        */
        
        if(s==null||s.length()==0)
            return s;
        
        StringBuilder res = new StringBuilder();
        int lastAnchor = s.length();
        int iter = s.length()-1;
        //  i
        //        l
        //   "abcd     m   " "m "
        //keep iterating while there's still omseinthg to read
        while(iter>=0){
            //if i cneocunter a " " then it means append what has been built since the last anchor then set anchor to the left
            if(s.charAt(iter)==' '){
                if(iter+1<lastAnchor)
                    res.append(s.substring(iter+1, lastAnchor)+" ");
                lastAnchor = iter;
            }
            iter--;
        }
        if(iter+1<lastAnchor)
            res.append(s.substring(iter+1, lastAnchor)+" ");
        return res.length()==0?"":res.substring(0, res.length()-1);
    }
}