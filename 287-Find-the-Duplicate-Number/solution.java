public class Solution {
    public int findDuplicate(int[] nums) {
        int fast = 0;
        int slow = 0;
        
        while(true){
            fast = nums[nums[fast]];
            slow = nums[slow];
            if(fast==slow)
                break;
        }
        
        int head = 0;
        while(head!=slow){
            head = nums[head];
            slow = nums[slow];
        }
        
        return slow;
    }
}