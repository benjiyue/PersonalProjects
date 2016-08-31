public class Solution {
	 public int jump(int[] A) {
		 if(A==null||A.length<2)
			 return 0;
		 int iter = 0;
		 int nextLevelMax = 0;
		 int currentLevelMax = 0;
		 int steps = 1;
		 while(currentLevelMax-iter>=0){
			 for(;iter<=currentLevelMax;iter++){
				 nextLevelMax = Math.max(nextLevelMax, iter+A[iter]);
				 if(nextLevelMax>=A.length-1)
					 return steps;
			 }
			 steps++;
			 currentLevelMax = nextLevelMax;
		 }
		 return steps;
	 }
}