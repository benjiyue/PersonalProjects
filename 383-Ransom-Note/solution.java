public class Solution {
	public boolean canConstruct(String ransomNote, String magazine) {
		//create count of letters from magazine and then ensure all ransomnote letter counts are less than that of magazine

		int[] mCount = new int[26];
		for(int i=0;i<magazine.length();i++)
			mCount[magazine.charAt(i)-'a']++;
		for(int i=0;i<ransomNote.length();i++){
			if(mCount[ransomNote.charAt(i)-'a']--==0)
				return false;
		}
		return true;
	}
}