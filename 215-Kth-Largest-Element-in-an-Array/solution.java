public class Solution {
	public int findKthLargest(int[] nums, int k) {
		//quickselect average O(n) time implement it with dutch national flag to guarantee linear time even if the array is sorted

		knuthShuffle(nums);

		//sort in descending order such that the ith element is the i+1th largest element
		int low = 0;
		int high = nums.length-1;
		while(low<=high){
			//quick select return the range where the chosen pivot occures
			int[] range = quickSelect(nums, low, high);
			//if the kth index is between the returned pivot then the number within that range is the kth highest element
			if(range[0]+1<=k&&k<=range[1]+1)
				return nums[range[0]];
			//else the kth largest is to the left
			else if(k<range[0]+1)
				high = range[0]-1;
			//else the kth largest is to the right
			else
				low = range[1]+1;
		}
		return -1;
	}

	public int[] quickSelect(int[] nums, int low, int high){
		int pivot = nums[low];
		int nextHigher = low;
		int iter = low;
		int nextLower = high;
		//nextHigher->     <-nextLower
		/*
                      L
        H
                       i
        1,1,1,1,1,1,1,1
		 */
		while(iter<=nextLower){
			if(nums[iter]<pivot){
				swap(nums, iter, nextLower);
				nextLower--;
			}else if(nums[iter]>pivot){
				swap(nums, iter, nextHigher);
				iter++;nextHigher++;
			}else{
				iter++;
			}
		}
		return new int[]{nextHigher, nextLower};
	}

	public void knuthShuffle(int[] nums){
		Random rand = new Random();
		for(int i=nums.length-1;i>0;i--){
			int randomPos = rand.nextInt(i+1);
			swap(nums, i, randomPos);
		}
	}

	public void swap(int[] in, int a, int b){
		int temp = in[a];
		in[a] = in[b];
		in[b] = temp;
	}
    
}