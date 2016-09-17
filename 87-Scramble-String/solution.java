public class Solution {
	public boolean isScramble(String s1, String s2) {
		//the solution is recursive and tries dividing the scrammbled word range into 2 parts such that it's from or back matches the same sized front of the orig, if it matches either then recurse for that, ie they're anagrams by iterating over their counts if so recurse
		map = new HashMap();
		return search(s1, s2);

	}
	Map<String, Boolean> map;
	
	//returns whether the given range can be rotations
	public boolean search(String orig, String scrambled){
		if(scrambled.equals(orig))
			return true;
		String key = orig+","+scrambled;
		if(map.containsKey(key))
			return map.get(key);
		//checkCount
		if(!sameCounts(orig, scrambled)){
			map.put(key, false);
			return false;
		}
		boolean res = false;
		for(int i=1;i<=orig.length()-1;i++){
			//
			String front = orig.substring(0,i);
			String back = orig.substring(i);
			boolean frontTofront = search(front,scrambled.substring(0,i))&&search(orig.substring(i),scrambled.substring(i));

			boolean frontToBack = search(front,scrambled.substring(scrambled.length()-i))&&search(orig.substring(i),scrambled.substring(0, scrambled.length()-i));

			if(frontTofront||frontToBack){
				res = true;
				break;
			}
		}
		map.put(key, res);
		return res;
	}

	public boolean sameCounts(String a, String b){
		int[] counts = new int[26];
		for(int i=0;i<a.length();i++){
			counts[a.charAt(i)-'a']++;
			counts[b.charAt(i)-'a']--;
		}
		for(int i=0;i<26;i++){
			if(counts[i]!=0)
				return false;
		}
		return true;
	}
}