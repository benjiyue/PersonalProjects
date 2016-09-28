public class Solution {
	public int strStr(String text, String pattern) {
	    if(pattern.length()>text.length())
	        return -1;
	    
		final int base = 113;
		long patternHash = 0;
		long textHash =0;
		//hash the pattern
		for(int i=0;i<pattern.length();i++){
			patternHash += (Math.pow(base,i)*pattern.charAt(i));
		}
		//hash up the size of the pattern of text
		for(int i=0;i<pattern.length();i++){
			textHash += (Math.pow(base,i)*text.charAt(i));
		}
		if(textHash==patternHash&&areMatch(text, pattern.length()-1,pattern, pattern.length()-1))
			return 0;
		double pow = Math.pow(base, pattern.length()-1);
		for(int i=pattern.length();i<text.length();i++){
			//remove the leftmost character which will have exp of 1
			textHash-=text.charAt(i-pattern.length());
			textHash/=base;
			textHash += (pow*text.charAt(i));
			if(textHash==patternHash&&areMatch(text,i,pattern, pattern.length()-1))
				return i+1-pattern.length();
		}
		return -1;
	}

	public boolean areMatch(String a, int aIndex ,String b, int bIndex){
		while(bIndex>=0){
			if(a.charAt(aIndex)!=b.charAt(bIndex))
				return false;
			aIndex--;
			bIndex--;
		}
		return true;
	}
}