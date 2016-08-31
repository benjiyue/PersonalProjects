public class Solution {
	boolean isScramble(String _a, String _b){
		a = _a;
		b = _b;
		map = new HashMap<String, Boolean>();
		return isScramble(0, a.length(), 0, b.length());
	}
	
	Map<String, Boolean> map;
	String a;
	String b;
	
	boolean isScramble(int aLow, int aHigh, int bLow, int bHigh) {
		String key = aLow+","+aHigh+","+bLow+","+bHigh;
		if(a.substring(aLow, aHigh).equals(b.substring(bLow, bHigh))){
			map.put(key, true);
			return true;
		}
		
		int[] aCount = new int[26];
		int[] bCount = new int[26];
		for(int i=0;i<(aHigh-aLow);i++){
			aCount[a.charAt(aLow+i)-'a']++;
			bCount[b.charAt(bLow+i)-'a']++;
		}
		for(int i=0;i<26;i++){
			if(aCount[i]!=bCount[i]){
				map.put(key, false);
				return false;
			}
		}
		
		//i is the length of the left substring
		for(int i=1;i<(aHigh-aLow);i++){
			//first do them without inversion
			//first chunks match exactly
			if(isScramble(aLow, aLow+i, bLow, bLow+i)&&
					isScramble(aLow+i, aHigh, bLow+i, bHigh)){
				map.put(key, true);
				return true;
			}
			if(isScramble(aLow, aLow+i,bHigh-i,bHigh)&&
					isScramble(aLow+i, aHigh, bLow, bHigh-i)){
				map.put(key, true);
				return true;
			}
			//do them with inversion
			//first match with back and back of second match with front
		}
		map.put(key, false);
		return false;
		
	}
}