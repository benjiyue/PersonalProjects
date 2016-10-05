public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        /*
        idea is backtracking at each anchor the first time we dont select it then we enter a loop to select it as many times as podsible while the sum is still less than the target then we recurse to the next index
        */
        
        List<List<Integer>> res = new LinkedList();
        
        dfs(candidates, 0, 0, target, res, new LinkedList());
        return res;
    }
    /*
    res:7, 
        i
    [2, 3, 6, 7]
    */
    
    public void dfs(int[] candidates, int index, int sum, int target, List<List<Integer>> res, List<Integer> building){
        if(sum==target){
            res.add(new LinkedList(building));
            return;
        }
        if(index>=candidates.length)
            return;
            
        dfs(candidates, index+1, sum, target, res, building);
        int numsAdded = 0;
        while(sum+candidates[index]<=target){
            numsAdded++;
            sum+=candidates[index];
            
            building.add(candidates[index]);
            dfs(candidates, index+1,sum,target, res, building);
        }
        while(numsAdded-->0)
            building.remove(building.size()-1);
    }
}