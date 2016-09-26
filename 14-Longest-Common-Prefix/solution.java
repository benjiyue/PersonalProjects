public class Solution {
    public String longestCommonPrefix(String[] strs) {
        /*
        abc
        ab
        abb
        prefix = ab
        */
        if(strs==null||strs.length==0)
            return "";
        String prefix = strs[0];
        for(int i=1;i<strs.length;i++){
            String cur = strs[i];
            int iter = 0;
            while(iter<cur.length()&&iter<prefix.length()){
                if(prefix.charAt(iter)!=cur.charAt(iter)){
                    break;
                }
                else
                    iter++;
            }
            prefix = cur.substring(0,iter);
        }
        return prefix;
        //assume that initllay that the first element if the prefix then when i iterate over the rest of the aray, I will iterate along the prefix i have until one of them breaks, thenassign that to the prefix
    }
}