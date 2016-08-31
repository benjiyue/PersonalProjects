public class Solution {
	//the higher number can never become the lower number
	public int rangeBitwiseAnd(int m, int n) {
		if(n>m){
			int temp = m;
			m = n;
			n = temp;
		}
		int step = 0;
		while(m!=n){
			//if either 0 then of course it's useless conitnue

			m>>=1;
			n>>=1;

			//both are 1 in that case it meant that n<a number<m could've been formed by making this 
			//index a 0 and making all right indices 1's since that number is simply -1 of current
			step++;
		}
		return m<<step;
	}
}