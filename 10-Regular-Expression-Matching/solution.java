public class Solution {
    public boolean isMatch(String s, String p) {
        /*
        it's backtracking, with two poitners into s and p . What we do is that at each index of p we must look forward if it's a *, then we have to match 0 to p.length number of the current iteem, else we match the literal or the . which matches anything, if it is the * condition we try 0, then 1, then2... to the end of the s array and if it fails all the way then return false; else if at anytime it's true wee return true
        true matches come when both pointers are at the end
        */
        if(s==null||p==null)
            return false;
        
        return dfs(s, 0, p, 0);
    }
    
    public boolean dfs(String raw, int rawIndex, String pattern, int patternIndex){
        if(rawIndex==raw.length()&&patternIndex==pattern.length())
            return true;
        
        //match 0 to the end of raw number if each 
        if(patternIndex+1<pattern.length()&&pattern.charAt(patternIndex+1)=='*'){
            //match 0
            if(dfs(raw, rawIndex, pattern, patternIndex+2))
                return true;
            //now try to match as much as needed increasing by one as needed
            while(isMatch(raw, rawIndex, pattern, patternIndex)){
                if(dfs(raw, ++rawIndex, pattern, patternIndex+2))
                    return true;
            }
        }else{
            if(isMatch(raw, rawIndex, pattern, patternIndex)){
                if(dfs(raw, rawIndex+1, pattern, patternIndex+1))
                    return true;
            }
        }
        return false;
    }
    
    public boolean isMatch(String a, int aIndex, String b, int bIndex){
        if(aIndex>=a.length()||bIndex>=b.length())
            return false;
        if(b.charAt(bIndex)=='.')
            return true;
        return a.charAt(aIndex)==b.charAt(bIndex);
    }
    
}