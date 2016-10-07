public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        /*
        
        first need to sort
        
        find 2 numbers via for loop then the other 2 via 2 pointer, but each time when the form the solution we must skip all the things that are the same as the current
        
        same when moving the for loops
        */
        List<List<Integer>> res = new LinkedList();
        if(nums==null||nums.length<4)
            return res;
        Arrays.sort(nums);
        
        for(int i=0;i<nums.length-3;){
            for(int j=i+1;j<nums.length-2;){
                int low = j+1;
                int high = nums.length-1;
                while(low<high){
                    int sum = nums[i]+nums[j]+nums[low]+nums[high];
                    if(sum==target){
                        List<Integer> temp = new LinkedList();
                        temp.add(nums[i]);temp.add(nums[j]);temp.add(nums[low]);temp.add(nums[high]);
                        res.add(temp);
                        int lowVal = nums[low];
                        int highVal = nums[high];
                        while(low<high&&nums[low]==lowVal)
                            low++;
                        while(low<high&&nums[high]==highVal)
                            high--;
                    }else if(sum<target){
                        low++;
                    }else
                        high--;
                }
                int jVal = nums[j];
                while(j<nums.length-2&&nums[j]==jVal)
                    j++;
            }
            int iVal = nums[i];
            while(i<nums.length-3&&nums[i]==iVal)
                i++;
        }
        return res;
    }
}