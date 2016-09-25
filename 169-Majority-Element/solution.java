public class Solution {
    public int majorityElement(int[] nums) {
        /*
        idea is to have a value which represents the majority element thus far and to increment its count when we see it and decrement its count when we see another number, if it goes to 0 then we replcae with the current number
        
        03323
        
        */
        
        if(nums==null||nums.length==0)
            return 0;
        
        int num = nums[0];
        int times = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==num)
                times++;
            else{
                times--;
                if(times==0){
                    num = nums[i];
                    times = 1;
                }
            }
        }
        return num;
    }
}