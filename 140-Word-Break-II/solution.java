public class Solution {
    /*
    idea is that you return a list of string representing all the things after you do the strungbuilder if it has something you prepend the stringbuilder to each of the things and add to thisLevel list of strings. 
    */
    public List<String> wordBreak(String s, Set<String> set) {
        List<String> res = new LinkedList();
        res.addAll(dfs(s, set, new HashMap<String, List<String>>()));
        return res;
    }
    
    public List<String> dfs(String s, Set<String> set, Map<String, List<String>> map){
        if(s.equals("")){
            List<String> ret = new LinkedList();
            ret.add("");
            return ret; 
        }
        if(map.containsKey(s))
            return map.get(s);
            
        List<String> thisLevel = new LinkedList();
        StringBuilder cur = new StringBuilder();
        for(int i= 0;i<s.length();i++){
            cur.append(s.charAt(i));
            if(set.contains(cur.toString())){
                List<String> gotten = dfs(s.substring(i+1), set, map);
                if(gotten.size()>0){
                    for(String nextStr:gotten){
                    	thisLevel.add(nextStr.equals("")?(cur.toString()):cur.toString()+" "+nextStr);
                    }
                }
            }
        }
        
        map.put(s, thisLevel);
        
        return thisLevel;
    }
}