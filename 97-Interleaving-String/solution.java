public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        //idea is dfs with memoization
        //start all three pointers at index 0, then ask if s3==both or just one of the characters
        //if only one then you must increment that and there is not iteration upon comeback
        //if both equal then if one fails try the other and increment
    	map = new HashMap();
        return dfs(s1, 0, s2, 0, s3, 0);
    }
    Map<String, Boolean> map;
    
    public boolean dfs(String s1, int s1Index, String s2, int s2Index, String s3, int s3Index){
    	if(s1Index==s1.length()&&s2Index==s2.length()&&s3Index==s3.length())
    		return true;
    	if(s3Index>=s3.length())
    	    return false;
    	String key = s1Index+","+s2Index+","+s3Index;
    	if(map.containsKey(key))
    		return map.get(key);
    	char toMatch = s3.charAt(s3Index);
    	boolean res;
    	//try 1 then go both
    	if(s1Index<s1.length()&&s2Index<s2.length()&&s1.charAt(s1Index)==toMatch&&s2.charAt(s2Index)==toMatch){
    		if(dfs(s1, s1Index+1, s2, s2Index, s3, s3Index+1)||
    				dfs(s1, s1Index, s2, s2Index+1, s3, s3Index+1))
    			res = true;
    		else
    			res = false;
    	}else if(s1Index<s1.length()&&s1.charAt(s1Index)==toMatch){
    		res = dfs(s1, s1Index+1, s2, s2Index, s3, s3Index+1);
    	}else if(s2Index<s2.length()&&s2.charAt(s2Index)==toMatch){
    		res = dfs(s1, s1Index, s2, s2Index+1, s3, s3Index+1);
    	}else
    		res = false;
    	
    	map.put(key, res);
    	return res;

    }
    
}