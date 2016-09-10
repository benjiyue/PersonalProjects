public class Solution {
	public String minWindow(String s, String t) {
		//first count the count of 5 characrers, and the total
		//then iterate through the s string each time deducting the number and if it's positive then reduce the total number, finall when the total is 0, the start shifting the left pointer until the count goes to 1 again, then use that min to compare to minever
		/*
               i
             l
        s: mbbac
           01234
        t: abcb
        uniquesLeft = 3
        count: a=0,b=0,c=0
        minStart = 0;
        minLen = inf
        leftP = 0
		 */
		int[] counts = new int[256];
		int uniquesLeft = 0;
		for(int i=0;i<t.length();i++){
			char c = t.charAt(i);
			if(counts[c]==0)
				uniquesLeft++;
			counts[c]++;
		}


		int minStart = 0;
		int minLen = Integer.MAX_VALUE;
		int leftP = 0;

		for(int i=0;i<s.length();i++){
			if(--counts[s.charAt(i)]==0)
				uniquesLeft--;

			while(uniquesLeft==0){
				char c = s.charAt(leftP++);
				counts[c]++;
				if(counts[c]==1){
					uniquesLeft++;
					if(i-leftP+2<minLen){
						minLen = i-leftP+2;
						minStart = leftP-1;
					}
				}
			}
		}
		return minLen==Integer.MAX_VALUE?"":s.substring(minStart, minStart+minLen);
	}
}