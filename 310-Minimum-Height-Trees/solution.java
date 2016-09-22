public class Solution {
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		//create in degree counter and also make the adjacency matrix then for each non leaf node/ie it has in degree of >1 do a dfs to all leaf nodes and record the max as that's its height and save, runtime is v(v+e)

		//a better solution was to first map the adjacency matrix then start removing the graph in layers at each level search for the nodes with only 1 thing in their adjaceny list ie meaning they're the leaves and remove the mapping from both. Then when the map only has >2 things left indicated by some counter then we stop
		List<Integer> res = new LinkedList();
		List<Set<Integer>> adjList = new ArrayList();
		for(int i=0;i<n;i++)
			adjList.add(new HashSet());

		for(int i=0;i<edges.length;i++){
			adjList.get(edges[i][0]).add(edges[i][1]);
			adjList.get(edges[i][1]).add(edges[i][0]);
		}

		int counter = n;

		//guaranteed to be connected, not disjoint
		while(counter>2){
			List<Integer> sizeOneIndices = new LinkedList();
			for(int i=0;i<adjList.size();i++){
				if(adjList.get(i)!=null&&adjList.get(i).size()==1)
					sizeOneIndices.add(i);
			}
			for(Integer i:sizeOneIndices){
				Set<Integer> curList = adjList.get(i);
				Iterator<Integer> it = curList.iterator();
				int other = it.next();
				adjList.get(other).remove(i);
				adjList.set(i, null);
				counter--;
			}
			//if delete to nothing then reduce size
		}
		for(int i=0;i<adjList.size();i++){
			if(adjList.get(i)!=null)
				res.add(i);
		}
		return res;
	}
}