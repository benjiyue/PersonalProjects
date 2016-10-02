public class Solution {
    public List<String> summaryRanges(int[] nums) {
        /*
        we anhor at the start of a potential sequence, then we iterate for all things greater while the next thing is 1 greater than befre continue/increment iter until the next thing isn't 1 greater then the length of the sequence is anchor+right-left else if it's just 1 thing then we just put one nubmer
               i
               j
        [0,1,5]
         0
        */
        List<String> res = new LinkedList();
        if(nums==null||nums.length==0)
            return res;
        int anchor = 0;
        while(anchor<nums.length){
            int right = anchor+1;
            while(right<nums.length&&nums[right]==nums[right-1]+1)
                right++;
            int diff = right-anchor-1;
            if(diff==0)
                res.add(nums[anchor]+"");
            else
                res.add(nums[anchor]+"->"+(nums[anchor]+diff));
            anchor = right;
        }
        return res;
    }
}