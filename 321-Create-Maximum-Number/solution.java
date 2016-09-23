public class Solution {
	public int[] maxNumber(int[] nums1, int[] nums2, int k) {
		//try all combinations from the two then 0,k ->k,0 then merge the values together in attempy to form the highest
		int[] res = new int[k];
		for(int i=0;i<=k;i++){
			int j = k-i;
			int[] a = getMax(i, nums1);
			int[] b = getMax(j, nums2);
			if(a.length+b.length==k){
				int[] max = getMaxCombo(a,b, k);
				if(aBiggerThanB(max, 0, res, 0))
					res = max;
			}
		}
		return res;
	}
	/* i=1
	 * j=2
	 *    i
	 * [3,9] 1>=1
	 * [8,9]
	 * stack:9
	 */
	public int[] getMax(int size, int[] nums){
		if(size>nums.length||size==0)
			return new int[]{};
		Stack<Integer> stack = new Stack();
		int iter = 0;
		while(iter<nums.length){
			while(!stack.isEmpty()&&nums.length-iter>=size-(stack.size())+1&&nums[iter]>stack.peek())
				stack.pop();
			if(stack.size()<size)
				stack.push(nums[iter]);
			iter++;
		}
		//0123
		int[] res = new int[size];
		int counter =0;
		for(Integer i:stack)
			res[counter++] = i;
		return res;
	}
	
	public boolean aBiggerThanB(int[] a, int aStart, int[] b, int bStart){
		while(aStart<a.length&&bStart<b.length&&a[aStart]==b[bStart]){
			aStart++;
			bStart++;
		}
		return bStart==b.length||(aStart<a.length&&a[aStart]>b[bStart]);
	}
	
	public int[] getMaxCombo(int[] a, int[] b, int size){
		int[] res = new int[size];
		int aPointer = 0;
		int bPointer = 0;
		int nextPos = 0;
		while(nextPos<size){
			int aVal = aPointer==a.length?Integer.MIN_VALUE:a[aPointer];
			int bVal = bPointer==b.length?Integer.MIN_VALUE:b[bPointer];
			if(aVal>bVal){
				res[nextPos++] = a[aPointer++];
			}else if(aVal<bVal)
				res[nextPos++] = b[bPointer++];
			else{
				res[nextPos++] = aBiggerThanB(a,aPointer, b, bPointer)?a[aPointer++]:b[bPointer++];;
			}
				
		}
		return res;
	}
}