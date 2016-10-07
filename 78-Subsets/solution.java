public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        /*
        first dont select the number then select it once and recurse for the next unique number
        
        do it by adding the current number to all things i nthe list assuming it is not the same as the previous number. if it is then you have to add it only to the lasr layer added and append to it
        
        
        but when reach a sequence of the same character you count the number of dups and then select increasing number of them as you backtrack further. first selct 0 to n
        
        */
        List<List<Integer>> res = new LinkedList();
        dfs(nums, 0, res, new LinkedList<Integer>());
        return res;
    }
    
    public void dfs(int[] nums, int index, List<List<Integer>> res, List<Integer> building){
        if(index==nums.length){
            res.add(new LinkedList(building));
            return;
        }

        dfs(nums, index+1, res, building);
        
        building.add(nums[index]);
        dfs(nums, index+1,res,building);
        building.remove(building.size()-1);

    }
}