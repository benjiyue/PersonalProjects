public class Solution {
    public String convert(String s, int numRows) {
        //the diagonal length is 2 less
        /*
              i
        ("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
        0:PA
        1:APL
        2:YI
        
        */
        if(s==null||s.length()==0||numRows<2)
            return s;
        StringBuilder[] res = new StringBuilder[numRows];
        for(int i=0;i<numRows;i++){
            res[i] = new StringBuilder();
        }
        int index = 0;
        while(index<s.length()){
            for(int a=0;a<numRows&&index<s.length();a++,index++)
                res[a].append(s.charAt(index));
            for(int a=numRows-2;index<s.length()&&a>0;a--, index++)
                res[a].append(s.charAt(index));
        }
        StringBuilder toReturn = new StringBuilder();
        for(int i=0;i<numRows;i++){
            toReturn.append(res[i].toString());
        }
        return toReturn.toString();
    }
}