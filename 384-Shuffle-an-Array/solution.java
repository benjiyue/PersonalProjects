public class Solution {
	int[] initialValues;
	int[] current;
	Random rand;
	public Solution(int[] nums) {
		initialValues = nums;
		current = Arrays.copyOf(nums, nums.length);
		rand = new Random();
	}

	/** Resets the array to its original configuration and return it. */
	public int[] reset() {
		for(int i=0;i<current.length;i++)
			current[i] = initialValues[i];
		return current;
	}

	/** Returns a random shuffling of the array. */
	public int[] shuffle() {
		for(int i=current.length-1;i>=1;i--){
			int swap = rand.nextInt(i+1);
			int temp = current[swap];
			current[swap] = current[i];
			current[i] = temp;
		}
		return current;
	}
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */