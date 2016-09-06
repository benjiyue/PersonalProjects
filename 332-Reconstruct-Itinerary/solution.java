public class Solution {
	public List<String> findItinerary(String[][] tickets) {
		// create an adjacency list of the values, then sort each list then start the recursion with JFK, and append to the list each recursion, then return
		Map<String, LinkedList<String>> map = new HashMap();
		for(int i=0;i<tickets.length;i++){
			if(!map.containsKey(tickets[i][0])){
				map.put(tickets[i][0], new LinkedList<String>());
			}
			map.get(tickets[i][0]).add(tickets[i][1]);
		}

		for(String s:map.keySet()){
			Collections.sort(map.get(s));
		}

		List<String> res = new LinkedList();
		dfs(map, "JFK", res);
		return res;
	}

	public void dfs(Map<String, LinkedList<String>> map, String cur, List<String> res){
		while(map.get(cur)!=null&&map.get(cur).size()>0){
			Queue<String> neighbors = map.get(cur);
			String front = neighbors.remove();
			dfs(map, front, res);
		}
		res.add(0, cur);
	}
}