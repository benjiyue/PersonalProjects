public class NumArray {
    int[] values;
    int[] BITvalues;
    public NumArray(int[] nums) {
        values = new int[nums.length];
        BITvalues = new int[nums.length+1];
        for(int i=0;i<nums.length;i++)
            update(i, nums[i]);
    }

    void update(int i, int val) {
        int diff = val-values[i];
        values[i] = val;
        i++;
        while(i<BITvalues.length){
            BITvalues[i]+=diff;
            i+=i&(-i);
        }
    }

    public int sumRange(int i, int j) {
        return sumRange(j)-sumRange(i-1);
    }
    
    public int sumRange(int i){
        i++;
        int sum = 0;
        while(i>0){
            sum+=BITvalues[i];
            i-=i&(-i);
        }
        return sum;
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);