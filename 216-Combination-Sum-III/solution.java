public class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum3(int k, int n) {
        res = new LinkedList();
        if(k==0)
            return res;
            
        dfs(k, n, 1, 0, new LinkedList<Integer>());
        //then recurse and on each one choose up to the number of times the current number appears. If sum greater than n return else keep selecting but set the next index when recurse to index of nuext unique
        return res;
    }
    
    public void dfs(int stillNeed, int targetSum, int curIndex, int curSum, List<Integer> building){
        if(targetSum==curSum&&stillNeed==0){
            res.add(new LinkedList<Integer>(building));
            return;
        }
        if(curSum>=targetSum||stillNeed<=0||curIndex>9)
            return;
        //select this num as many times as possibly left
        
        dfs(stillNeed, targetSum, curIndex+1, curSum, building);

            curSum+=curIndex;
            stillNeed--;
            building.add(curIndex);
            dfs(stillNeed, targetSum, curIndex+1, curSum, building);
            building.remove(building.size()-1);
    }
}