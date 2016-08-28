public class Solution {
	public int longestConsecutive(int[] nums) {

		if(nums==null||nums.length<1)
			return 0;

		Map<Integer, Integer> map = new HashMap<>();
		int maxEver = 1;

		for(int i=0;i<nums.length;i++){
			if(!map.containsKey(nums[i])){
				int left = map.containsKey(nums[i]-1)?map.get(nums[i]-1):0;
				int right = map.containsKey(nums[i]+1)?map.get(nums[i]+1):0;
				
				maxEver = Math.max(maxEver, left+right+1);
				map.put(nums[i], left+right+1);
				map.put(nums[i]-left, left+right+1);
				map.put(nums[i]+right, left+right+1);
			}
		}
		return maxEver;

	}
}