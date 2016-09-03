public class Solution {

	public int maxProduct(String[] words) {
		int[] bits = new int[words.length];

		for(int i=0;i<words.length;i++){
			String cur = words[i];
			int thisWordBits = 0;
			for(int j=0;j<cur.length();j++){
				int offset = cur.charAt(j)-'a';
				int toOr = 1;
				toOr<<=offset;
				thisWordBits|=toOr;
			}
			bits[i] = thisWordBits;
		}

		int maxLen = 0;
		for(int i=0;i<words.length;i++){
			for(int j=i+1;j<words.length;j++){
				if((bits[i]&bits[j])==0){
					maxLen = Math.max(maxLen, words[i].length()*words[j].length());
				}
			}
		}
		return maxLen;
	}
}