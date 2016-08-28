public class Solution {
	public int longestConsecutive(int[] nums) {

		if(nums==null||nums.length<1)
			return 0;
		Set<Integer> set = new HashSet<>();
		for(int i=0;i<nums.length;i++){
			set.add(nums[i]);
		}
		int max = 1;
		for(Integer i:set){
			if(!set.contains(i-1)){
				int beginNum = i;
				int cur = i;
				while(set.contains(cur))
					cur++;
				max = Math.max(cur-beginNum, max);
			}
		}
		return max;
		
	}
}