public class Solution {
	public int ladderLength(String beginWord, String endWord, Set<String> set) {
		/*
        also add the final word into the set
        ida is bfs with a queue of transformations, for each word in the array transform each of the letters in the array and see if it's in the set if it is add it to the queue and remove the mapping from the set because we never want to visit it again because we know this is the earliest we can get to the word. if the end word is used then return the number of steps it took to get here which we count via acounter
		 */
		set.add(endWord);
		Queue<String> queue = new LinkedList();
		queue.add(beginWord);

		if(beginWord.equals(endWord))
			return 0;

		int steps = 2;
		while(!queue.isEmpty()){
			int size = queue.size();
			//iterate the next layer
			for(int a=0;a<size;a++){
				String next = queue.poll();
				char[] chars = next.toCharArray();
				set.remove(next);
				//change each index
				for(int i=0;i<next.length();i++){
					//try each letter
					for(char j='a';j<='z';j++){
						if(j!=chars[i]){
							chars[i] = j;
							String possible = new String(chars);
							if(possible.equals(endWord))
								return steps;
							if(set.contains(possible)){
								set.remove(possible);
								queue.add(possible);
							}
						}
					}
					chars[i] = next.charAt(i);
				}
			}
			steps++;
		}
		return 0;
	}
}