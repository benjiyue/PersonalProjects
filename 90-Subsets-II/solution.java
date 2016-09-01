public class Solution {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> res = new LinkedList();
		if(nums==null||nums.length==0)
			return res;
		//sort the array
		Arrays.sort(nums);
		List<Integer> building = new LinkedList();
        res.add(new LinkedList());
		dfs(nums, building, -1, res);
		
		return res;
		//send in recursively a string and the index of the last number, then in the 
		//recursion start with+1 of it and use it then find the next unique number, 
		//and mark the end and send recursively, but also add the current construction
	}

	public void dfs(int[] nums,List<Integer> building, int lastIndexUsed, List<List<Integer>> res){
		for(int i=lastIndexUsed+1;i<nums.length;i++){

			//if im the first of the sequence or this is the end of the sequece and im at the end of the list and i now need to add this num
			if(i==lastIndexUsed+1||nums[i]!=nums[i-1]){
				building.add(nums[i]);
				res.add(new LinkedList(building));
				dfs(nums, building, i, res);
				building.remove(building.size()-1);
			}
		}
	}
}