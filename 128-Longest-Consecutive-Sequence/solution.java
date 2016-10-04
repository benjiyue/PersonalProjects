public class Solution {
	public int longestConsecutive(int[] nums) {
		Map<Integer, Integer> map = new HashMap();
		for(int i=0;i<nums.length;i++){
			if(map.containsKey(nums[i]))
				continue;
			map.put(nums[i], i);
		}
		//we iterate over the values and try to union the nums[i] with nums[i]-1 and nums[i]+1 if the -1 and +1 exist in the map

		UF uf = new UF(nums.length);

		for(int i=0;i<nums.length;i++){
			int val = nums[i];
			if(map.containsKey(val-1)){
				uf.union(map.get(val), map.get(val-1));
			}
			if(map.containsKey(val+1)){
				uf.union(map.get(val), map.get(val+1));
			}
		}

		//we count the number of indices that are mapped to some representative and the largest value will be the result
		int maxSize = 1;
		for(int i=0;i<uf.sizes.length;i++){
			maxSize = Math.max(uf.sizes[i], maxSize);
		}
		return maxSize;
	}

	public class UF{

		int[] rep;
		int[] sizes;

		public UF(int size){
			rep = new int[size+1];
			for(int i=0;i<size+1;i++)
				rep[i] = i;

			sizes = new int[size+1];
			Arrays.fill(sizes, 1);
		}

		public void union(int a, int b){
			int aRep = find(a);
			int bRep = find(b);
			if(aRep==bRep)
				return;

			if(sizes[aRep]>sizes[bRep]){
				rep[bRep] = aRep;
				sizes[aRep]+=sizes[bRep];
			}else{
				rep[aRep] = bRep;
				sizes[bRep]+=sizes[aRep];
			}

		}

		public int find(int index){
			//while i am not the rep of myself set my rep to my grandparent then continue the while
			while(rep[index]!=index){
				//set my rep to my grandparent
				rep[index] = rep[rep[index]];
				//set the cur index to grandparent
				index = rep[index];
			}
			return index;
		}

	}
}