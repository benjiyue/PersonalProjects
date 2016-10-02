public class Solution {
	public List<Integer> largestDivisibleSubset(int[] nums) {
		//[1,2,4,8]
		//[1,2,3,4]

		//sort it first, then the n^2 solution is like the lingest increasing subsequence question each number we keep track of the longest sequence it can be the end element of. for each element we iterate over the all things to the left and we can use that subsequence if that left thing can mod me or i can mod it without remainder, thenw e have to trace back the result
		List<Integer> res = new LinkedList();
        if(nums==null||nums.length==0)
            return res;
        if(nums.length==1){
            res.add(nums[0]);
            return res;
        }
		Arrays.sort(nums);
		int[] dp = new int[nums.length];
		int[] prev = new int[nums.length];
		dp[0] = 1;
		int maxEver = 0;
		Arrays.fill(prev, -1);
		for(int i=1;i<nums.length;i++){
			int thisMax = 0;
			for(int j=0;j<i;j++){
				if(nums[i]%nums[j]==0){
					if(dp[j]>thisMax){
						thisMax = dp[j];
						prev[i] = j;
					}
				}
			}
			dp[i] = thisMax+1;
			maxEver = Math.max(thisMax+1, maxEver);
		}
		int i= nums.length-1;
		for(;i>=0;i--){
			if(dp[i]==maxEver)
				break;
		}

		
		while(prev[i]!=-1){
			res.add(nums[i]);
			i = prev[i];
		}
		res.add(nums[i]);
		Collections.reverse(res);
		return res;
	}
}