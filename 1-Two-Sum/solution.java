public class Solution {
    public int[] twoSum(int[] nums, int target) {
        /* use a map to record the conjugate value and the current index. 
            when we see something in the map then return the other index
        */
        Map<Integer, Integer> map = new HashMap();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                int[] res = new int[2];
                res[0] = map.get(nums[i]);
                res[1] = i;
                return res;
            }
            map.put(target-nums[i], i);
        }
        return new int[]{};
    }
}