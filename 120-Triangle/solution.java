public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        /*
        we do a dfs with memoization. we set our anchor and then recurse to the nxt legvel down and there we can schoose i or i+1, then explore both. when we return we save the best choice for this depth this idnex and memoize before we return
        */
        
        return dfs(triangle, 0, 0, new HashMap<String, Integer>());
        /*
[
    8[2],9
    [3,4],
   [6,5,7]
]
        */
    }
    
    public int dfs(List<List<Integer>> triangle, int depth, int index, Map<String, Integer> map){
        if(depth>=triangle.size())
            return 0;
        
        String key = depth+","+index;
        if(map.containsKey(key))
            return map.get(key);
            
        int left = dfs(triangle, depth+1, index, map);
        int right = dfs(triangle, depth+1, index+1, map);
        int min = Math.min(left, right);
        int val = triangle.get(depth).get(index);
        map.put(key, min+val);
        
        return min+val;
        
    }
}