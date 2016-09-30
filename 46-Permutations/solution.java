public class Solution {
	public List<List<Integer>> permute(int[] nums) {
		//back tracking solution pass in current index then swap the current index for ll future indices and upon doing that recurse to the swapped further index+1 and continue until the last index and just add the result
		List<List<Integer>> res = new LinkedList();
		if(nums==null||nums.length==0)
			return res;

		dfs(nums, 0, res);
		return res;
	}

	public void dfs(int[] nums, int index, List<List<Integer>> res){
		if(index==nums.length){
			List<Integer> cur = new LinkedList();
			for(int i=0;i<nums.length;i++)
				cur.add(nums[i]);
			res.add(cur);
			return;
		}
		int orig = nums[index];
		for(int i=index;i<nums.length;i++){
			nums[index] = nums[i];
			nums[i] = orig;
			dfs(nums, index+1, res);
			nums[i] = nums[index];
			nums[index] = orig;
		}
	}
    /*
    [321]
    
    123
    132
    213
    231
    321
    312
    */
}