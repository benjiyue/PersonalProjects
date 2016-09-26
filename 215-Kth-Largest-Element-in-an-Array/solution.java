public class Solution {
	public int findKthLargest(int[] nums, int k) {
		if(nums==null||nums.length==0)
			return -1;
		int low = 0;
		int high = nums.length-1;
		while(low<=high){
			int pos = sort(low, high, nums);
			int myPos = nums.length-pos;
			if(k==myPos)
				return nums[pos];
			if(myPos>k)
				low = pos+1;
			else
				high = pos-1;
		}
		return -1;
	}

	public int sort(int low, int high, int[] nums){
		int lowOrigPos = low;
		int pivot = nums[low];
		low++;
		while(low<=high){
			if(nums[low]>=pivot&&nums[high]<pivot){
				int temp = nums[low];
				nums[low] = nums[high];
				nums[high] = temp;
				high--;
				low++;
			}
			if(nums[high]>=pivot)
				high--;
			if(nums[low]<pivot)
				low++;
		}
		nums[lowOrigPos] = nums[high];
		nums[high] = pivot;
		return high;
	}
}