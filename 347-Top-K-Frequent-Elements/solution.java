public class Solution {
	public List<Integer> topKFrequent(int[] nums, int k) {
		//given a size n array the most a number can appear is n times , basically the size of the array tells you the range of how many times anything can possibly  appear 
		List<Integer> res = new LinkedList();
		if(nums==null||nums.length==0)
			return res;
		//make the array an array of lists
		List<Integer>[] occur = new LinkedList[nums.length+1];
		Map<Integer, Integer> count = new HashMap();
		for(Integer i:nums){
			if(count.containsKey(i))
				count.put(i, count.get(i)+1);
			else
				count.put(i, 1);
		}
		//and count the occurences of each number using map, then at the end insert into the array and count k things
		for(Integer key:count.keySet()){
			int howMany = count.get(key);
			if(occur[howMany]==null)
				occur[howMany] = new LinkedList<Integer>();
			occur[howMany].add(key);
		}
		
		for(int i=nums.length;i>=0;i--){
			if(occur[i]!=null){
				List<Integer> mapped = occur[i];
				for(Integer a:mapped){
					res.add(a);
					if(--k==0)
						return res;
				}
			}
		}
		return res;
	}
}