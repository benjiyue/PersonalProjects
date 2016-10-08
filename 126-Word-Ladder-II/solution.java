public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        /*
        you can't remove immediately, you only to remove once you've processed all things in the array ie have the next level then you can remove beacuse if you remove immiediately other people with same min distance may miss it
        
        so you need the map between the words -> list of where it could've cam from
        */
        
        //map how we can get to a certain word
        Map<String, Set<String>> fromMap = new HashMap();
        //things to visit
        Queue<String> queue = new LinkedList();
        queue.add(beginWord);
        wordList.add(endWord);
        wordList.remove(beginWord);
        //marker for when we finally find the endWord
        boolean isFinished = false;
        
        while(!queue.isEmpty()&&!isFinished){
            //we only remove words we visit once we clear a whole level
            Set<String> wordsToRemove = new HashSet();
            int thisLevel = queue.size();
            
            //iterate over things for this level/steps from the beginning
            for(int i=0;i<thisLevel;i++){
                String cur = queue.remove();
                StringBuilder temp = new StringBuilder(cur);
                
                for(int a=0;a<cur.length();a++){
                    char initial = cur.charAt(a);
                    for(char b = 'a';b<='z';b++){
                    	if(initial==b)
                    		continue;
                        temp.setCharAt(a,b);
                        String newWord = temp.toString();
                        //if it's in the dictionary
                        if(wordList.contains(newWord)){
                            
                            if(newWord.equals(endWord))
                                isFinished = true;
                            
                            if(!fromMap.containsKey(newWord))
                            	fromMap.put(newWord, new HashSet<String>());
                            fromMap.get(newWord).add(cur);
                            wordsToRemove.add(newWord);
                            queue.add(newWord);
                        }
                    }
                    temp.setCharAt(a, initial);
                }
            }
            for(String s:wordsToRemove)
                wordList.remove(s);
        }
        
        List<List<String>> res = new LinkedList();
        if(!isFinished)
        	return res;
        dfs(endWord, beginWord, fromMap, new LinkedList<String>(), res);
        return res;
    }
    
    public void dfs(String curWord, String beginWord, Map<String, Set<String>> fromMap, List<String> building, List<List<String>> res){
        if(curWord.equals(beginWord)){
            List<String> toAdd = new LinkedList(building);
            toAdd.add(0, beginWord);
            res.add(toAdd);
            return;
        }
        building.add(0, curWord);
        for(String s:fromMap.get(curWord)){
            dfs(s, beginWord, fromMap, building, res);
        }
        building.remove(0);
    }
    
}