public class Solution {
	//given an array of sorted number give any patches needed such that any combination sum of numbers
	//can add up to n
	int minPatches(int[] nums, int n) {
		long nextMaybeNot = 1;
		int added = 0;
		int iterator = 0;
		while(nextMaybeNot<=n){
			if(iterator<nums.length&&nums[iterator]<=nextMaybeNot){
				nextMaybeNot+=nums[iterator++];
			}else{
				nextMaybeNot+=nextMaybeNot;
				added++;
			}
		}
		return added;
	}
}