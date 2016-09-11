public class Solution {
	public int firstMissingPositive(int[] nums) {
		//put all the negatives to the end of the array then get the range 0->n which can support + numbers
		int nextPos = 0;
		for(int i=0;i<nums.length;i++){
			if(nums[i]>0)
				nums[nextPos++] = nums[i];
		}
		nextPos--;
		//then iterate from left to right swapping if both numbers are within n range else mark the spot with -1
		int index = 0;
		while(index<=nextPos){
			if(nums[index]>nextPos+1)
				index++;
			else if(nums[index]==index+1){
				index++;
			}else{
				if(nums[index]==nums[nums[index]-1])
					nums[index] = Integer.MAX_VALUE;
				else
					swap(nums, index, nums[index]-1);
			}
		}
		//then iterate to find the first spot with a -1 else the answer is +1 of the last positive side
		for(int i=0;i<=nextPos;i++){
			if(nums[i]!=i+1)
				return i+1;
		}
		return nextPos+2;
	}

	public void swap(int[] in, int i,int j){
		int temp = in[i];
		in[i] = in[j];
		in[j] = temp;
	}
}