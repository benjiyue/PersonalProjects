public class Solution {
	public List<Integer> findSubstring(String s, String[] words) {
		//it's a sliding window approach, first map all the words to their count then count how many uniques there are.
		List<Integer> res = new LinkedList();
		if(words.length==0||words[0].length()*words.length>s.length())
			return res;
		Map<String, Integer> dictMap = new HashMap();

		for(String i:words){
			if(dictMap.containsKey(i))
				dictMap.put(i, dictMap.get(i)+1);
			else{
				dictMap.put(i, 1);
			}
		}

		int oneWord = words[0].length();
		for(int offset=0;offset<words[0].length();offset++){
			Map<String, Integer> curMap = new HashMap();
			int l = offset;
			int r = offset;
			int exactCountMatches = 0;
			while(r+oneWord<=s.length()){
				String nextWord = s.substring(r, r+oneWord);
				if(dictMap.containsKey(nextWord)){
					if(curMap.containsKey(nextWord))
						curMap.put(nextWord, curMap.get(nextWord)+1);
					else{
						curMap.put(nextWord, 1);
					}

					if(curMap.get(nextWord)==dictMap.get(nextWord)){
						exactCountMatches++;
					}
					while(curMap.get(nextWord)>dictMap.get(nextWord)){
						//remove left words until in line
						String left = s.substring(l, l+oneWord);
						l+=oneWord;
						int already = curMap.get(left);
						curMap.put(left, already-1);
                        if(dictMap.get(left)==already)
                            exactCountMatches--;
					}
					//you'll bring the nextWord count to be==dictMap
					if(exactCountMatches==dictMap.size()){
						res.add(l);
						String left = s.substring(l, l+oneWord);
						int already = curMap.get(left);
						curMap.put(left, already-1);
						exactCountMatches--;
						l+=oneWord;
					}
					r+=oneWord;
				}else{
					curMap.clear();
					l = r+oneWord;
					r=l;
					exactCountMatches = 0;
				}
			}

		}
		return res;
		//then start at each possible offset from the beggining to the length of each of the words. 
		//create anew map and start the sliding window
		//ask if next substring is in the map if yes then process it and update the currentMap, if equal to the count of dictionary mapping, then increment counter, if counter==mapCounter then this is a result and add left pointer, then move left pointer
		//else if not in map reset map and put left to right+offset
	}
}