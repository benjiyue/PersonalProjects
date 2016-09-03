public class Solution {
	public int[] intersect(int[] nums1, int[] nums2) {
		if(nums1==null||nums2==null)
			return new int[0];
		//count occurences of numbers in nums1, then iterate through nums2 and deduct until go to end or map empty
		Map<Integer, Integer> map = new HashMap();
		for(Integer i:nums1){
			map.put(i, map.containsKey(i)? map.get(i)+1:1);
		}
		List<Integer> res = new ArrayList();
		for(Integer i:nums2){
			if(map.containsKey(i)){
				int left = map.get(i);
				if(left==1)
					map.remove(i);
				else
					map.put(i, left-1);
				res.add(i);
			}
		}
		int[] toReturn = new int[res.size()];
		int counter = 0;
		for(Integer i:res)
			toReturn[counter++] = i;
		return toReturn;
	}
}