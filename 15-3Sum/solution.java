public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        /*
        WHAT IF WANTED DUPS? YOU JUST FIND HOW MANY COMBOS THERE ARE OF THE SAME NUMBER AND MULTIPLY
        WHAT IF I WANTED <= NO DUPS, CAUSE WITH DUPS IS THE OTHER LEETCODE QUESTION
        
        idea is to have a root anchor and a 2 pointer approach, if the sum of 3 is too high then decrement higher poitner, if too low incremenent lower pointer, else it's a solution add the 3 values and then skip all nums of the same 
        */
        List<List<Integer>> res = new LinkedList();
        if(nums==null||nums.length<3)
            return res;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            int low = i+1;
            int high = nums.length-1;
            while(low<high){
                int curSum = nums[i]+nums[low]+nums[high];
                if(curSum==0){
                    List<Integer> ans = new LinkedList();
                    ans.add(nums[i]);
                    ans.add(nums[low]);
                    ans.add(nums[high]);
                    res.add(ans);
                    
                    int curLowVal = nums[low];
                    int curHighVal = nums[high];
                    while(low<high&&curLowVal==nums[low])
                        low++;
                    while(low<high&&curHighVal==nums[high])
                        high--;
                    
                }else if(curSum<0)
                    low++;
                else
                    high--;
            }
            int thisIVal = nums[i];
            while(i<nums.length-2&&nums[i]==thisIVal)
                i++;
            i--;
        }   
        /*i
                l
              h
        [-5,1,2,3]*/
        return res;
        
    }
}