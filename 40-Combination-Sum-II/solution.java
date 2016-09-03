public class Solution {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> res = new LinkedList();
		if(candidates==null||target==0)
			return res;
		//sort the numbers
		Arrays.sort(candidates);
		//then recursively try to generate the sum, except every time you recurse select it but then you set the index to the next unique element

		recurse(candidates, target, res, 0, new ArrayList<Integer>(candidates.length),0);
		return res;
	}

	public void recurse(int[] nums, int target, List<List<Integer>> res, int sumSoFar, List<Integer> considered, int index){
		if(target==sumSoFar){
			res.add(new LinkedList<Integer>(considered));
			return;
		}
		
		if(sumSoFar>target||index>=nums.length)
			return;
		
		int indexOfLast = index;
		while(indexOfLast<nums.length&&nums[indexOfLast]==nums[index])
			indexOfLast++;
		recurse(nums, target, res, sumSoFar, considered, indexOfLast);
		int timesAdded = 0;
		while(index<indexOfLast){
		    timesAdded++;
			considered.add(nums[index]);
			sumSoFar+=nums[index];
			if(sumSoFar>target)
				break;
			recurse(nums, target, res, sumSoFar, considered, indexOfLast);
			index++;
		}
		while(timesAdded>0){
		    considered.remove(considered.size()-1);
		    timesAdded--;
        }
	}
}