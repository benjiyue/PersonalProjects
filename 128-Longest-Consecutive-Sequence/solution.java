public class Solution {
	public int longestConsecutive(int[] nums) {
		UF uf = new UF(nums.length);

		//map from value to the index to avoid dups
		Map<Integer, Integer> map = new HashMap();
		for(int i=0;i<nums.length;i++){
			if(map.containsKey(nums[i]))
				continue;

			map.put(nums[i],i);
			if(map.containsKey(nums[i]+1))
				uf.union(i, map.get(nums[i]+1));
			if(map.containsKey(nums[i]-1))
				uf.union(i, map.get(nums[i]-1));
		}
		Map<Integer, Integer> count = new HashMap();
		int maxGroup = 1;
		for(int i=0;i<uf.size.length;i++)
			maxGroup = Math.max(maxGroup, uf.size[i]);
		return maxGroup;
	}


	class UF{
		int[] size;
		int[] representative;
		public UF(int length){
			size = new int[length];
			Arrays.fill(size, 1);
			representative = new int[length];
			for(int i=0;i<representative.length;i++)
				representative[i] = i;
		}

		public void union(int a, int b){
			int aRep = find(a);
			int bRep = find(b);
			if(aRep==bRep)
				return;

			if(size[aRep]>size[bRep]){
				size[aRep]+=size[bRep];
				representative[bRep] = aRep;
			}else{
				size[bRep]+=size[aRep];
				representative[aRep] = bRep;
			}
		}

		public int find(int node){
			while(representative[node]!=node){
				representative[node] = representative[representative[node]];
				node = representative[node];
			}
			return node;
		}

	}
}