public class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums==null)
            return 0;
        if(nums.length<2)
            return nums.length;
        //10, 9, 2, 5
        /*
        lowestEver = 0;
        highestEver = 1;
        low = 0;
        high = 1;
        */
        //2, 5, 0, 0, 0
        int[] longestWithIndexLength = new int[nums.length+1];
        //create array where each index represents the lowest value for that index
        //for each number in the array, do a bs to find the first index where it's less than the number stored there
        int lowestEver = 0;
        int highestEver = 0;
        for(int i=0;i<nums.length;i++){
            int low = lowestEver;
            int high = highestEver;
            int cur = nums[i];
            while(low<high){
                int mid = (low+high)/2;
                if(cur>longestWithIndexLength[mid])
                    low = mid+1;
                else
                    high = mid;
            }
            
            longestWithIndexLength[high] = cur;
            if(high==highestEver)
                highestEver++;
        }
        return highestEver;
    }
}