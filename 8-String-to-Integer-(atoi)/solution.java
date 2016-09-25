public class Solution {
    /*
    OK string to integer, what if overflow? return min or max
    
    OK must start with a valid start otherwise return 0
    
    OK also take care of negatives and positive that appear in the front
    
    OK what about whitespaces? delete all trailing and leading
    
    OK what about decimal
    
    OK what about invalid chars they can appear after the last valid digit but ignore them
    res = 123
            i
    "   -123MM"
    sign = -1;
    */
	public int myAtoi(String s) {
		if(s==null||s.length()==0)
			return 0;

		long res = 0;
		int iter = 0;
		int sign = 1;
		while(s.charAt(iter)==' ')
			iter++;

		if(s.charAt(iter)=='-'||s.charAt(iter)=='+'){
			sign = s.charAt(iter)=='-'?-1:1;
			iter++;
		}

		//it should now point to a digit
		while(iter<s.length()&&s.charAt(iter)>='0'&&s.charAt(iter)<='9'){
			int cur = s.charAt(iter++)-'0';
			res*=10;
			res+=cur;
			if(res>=Integer.MAX_VALUE){
				if(sign==1)
					return Integer.MAX_VALUE;
				if(res==Integer.MAX_VALUE&&sign==-1)
					return -1*Integer.MAX_VALUE;
				if(res>Integer.MAX_VALUE&&sign==-1)
					return Integer.MIN_VALUE;
			}
		}
		return sign==1?(int)res:-1*(int)res;
	}
}