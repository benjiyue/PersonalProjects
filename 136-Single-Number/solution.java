public class Solution {
    public int singleNumber(int[] nums) {
        /*
        Idea is bit manipulation, because exclusive or essentially gets rid of itself if we do something an even nnumber of times if we exclusive or each of the numbers that appear twice they'll get rid of themselves. But the thing that appeared once will just be left
        
        */
        int res = 0;
        for(int i=0;i<nums.length;i++)
            res^=nums[i];
        return res;
        /*
        3(11), 3(11), 2(01)
        01
        
        */
    }
}