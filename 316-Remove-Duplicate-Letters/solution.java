public class Solution {
	public String removeDuplicateLetters(String s) {
		//use a stack with a map of number of characters left of something
		//when you encounter a letter ask if it's less than the thing on the stack. if it is less then keep popping until you reach something that's even less than itself and put it after that OR until you reach something that has no occurences left

		int[] count = new int[26];
		for(int i=0;i<s.length();i++)
			count[s.charAt(i)-'a']++;

		Stack<Character> stack = new Stack();

		boolean[] occurs = new boolean[26];
		for(int i=0;i<s.length();i++){
			char c = s.charAt(i);
			count[c-'a']--;
			if(occurs[c-'a'])
				continue;
			while(!stack.isEmpty()){
				char peek = stack.peek();
				//i only stop popping when the char has no more left, or if im after it 
				if(peek<c||count[peek-'a']==0)
					break;
				char popped = stack.pop();
				occurs[popped-'a'] = false;
			}
			stack.push(c);
			occurs[c-'a'] = true;
		}
		StringBuilder res = new StringBuilder();
		while(!stack.isEmpty())
			res.append(stack.pop());
		return res.reverse().toString();
	}
}