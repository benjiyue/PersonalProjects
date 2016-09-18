public class Solution {
	public String shortestPalindrome(String s) {
		//you want to find the longest prefix that's a palindrome that way you can reuse as many characters as possible, then for the rest you basically flip the rest and put it to the front

		//how do you decide if something is a palindrome, you need to do a rolling hashrabin karp from front and from back
		//if something is still a palindrome ie both hashes are equal you then save the index, then in the end you get the substring [i] and append to front the reverse of it

		if(s==null||s.length()==0)
			return s;

		long hash1 = 0;
		long hash2 = 0;
		final int multiple = 101;
		long power = 1;

		int lastPos = -1;

		for(int i=0;i<s.length();i++){
			int c = s.charAt(i);
			
			//hash 1 puts the current to the highest power
			hash1=(hash1+c*power)%1000000001;
			
			//hash2 puts the current to the lowest
			hash2=(hash2*multiple+c)%1000000001;
			power = (power*101)%1000000001;
			
			if(hash1==hash2){
				//i was part of a palindrome
				lastPos = i;
			}
		}
		StringBuilder remainder = new StringBuilder(s.substring(lastPos+1));
		remainder.reverse();
		return remainder.toString()+s;
	}
}