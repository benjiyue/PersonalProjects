public class Solution {
    public String multiply(String num1, String num2) {
        /*
        we do hand multiplication of the string 
        
        i
        j
        we start with the i+j position and put the number going to the left in the result array
        result can only be of num1+num2 length at max, then invalidate the zero spaces and the rest will be the result.
        */
        
        if(num1==null||num1.length()==0||num2==null||num2.length()==0)
            return "0";
        
        int [] res = new int[num1.length()+num2.length()];//2+3 = 5    01  012  01234
        for(int i=num1.length()-1;i>=0;i--){
            for(int j=num2.length()-1;j>=0;j--){
                int product = (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                res[i+j+1] +=product;
            }
        }
        /*
        i
        9
        j
        999
        
        8 9 9 1
        0 1  2  3
        */
        for(int i=res.length-1;i>0;i--){
            res[i-1]+=res[i]/10;
            res[i]%=10;
        }
        StringBuilder toReturn = new StringBuilder();
        int iter = 0;
        while(iter<res.length&&res[iter]==0)
            iter++;
        
        while(iter<res.length)
            toReturn.append(res[iter++]);
        
        return toReturn.length()==0?"0":toReturn.toString();
    }
}