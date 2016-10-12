public class Solution {
	public List<Integer> findSubstring(String s, String[] words) {
		/*
        sliding window with a map:word->count/occurences

        slide the window up to the words.length*word[0].length and for each length deduct a count if it exists
        then if the count is 0 then return the left pointer. Else get rid of the left and consider the right. 
		 */

		Map<String, Integer> orig = new HashMap();
		int origCount = 0;
		for(String temp:words){
			if(orig.containsKey(temp))
				orig.put(temp, orig.get(temp)+1);
			else
				orig.put(temp, 1);
			origCount++;
		}
	
		
		List<Integer> res = new LinkedList();
        for(int i=0;i<words[0].length();i++){
            
            Map<String, Integer> map = new HashMap(orig);
	    	int count = origCount;
            
    		int left = 0+i;
    		int right = 0+i;
    
    		while(right+words[0].length()<=s.length()){
    			if(count==0)
    				res.add(left);
    			if(right>=words[0].length()*words.length){
    				//put left word back
    				String leftWord = s.substring(left, left+words[0].length());
    				if(map.containsKey(leftWord)){
    					int cur = map.get(leftWord);
    					if(cur>=0)
    						count++;
    					map.put(leftWord, cur+1);
    				}
    				left+=words[0].length();
    			}
    
    			//get rid of right word
    			String temp = s.substring(right, right+words[0].length());
    			if(map.containsKey(temp)){
    				int current = map.get(temp);
    				map.put(temp, current-1);
    				if(current>0)
    					count--;
    			}
    			right+=words[0].length();
    		}
    		if(count==0)
    			res.add(left);
        }
		return res;
	}
}