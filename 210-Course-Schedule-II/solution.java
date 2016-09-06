public class Solution {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		//build adjacency list and update in counters
		//then iterate to find onw with 0 in degree
		ArrayList<Integer>[] adjList = new ArrayList[numCourses];
		for(int i=0;i<adjList.length;i++)
			adjList[i] = new ArrayList<Integer>();

		int[] inDegree = new int[numCourses];
		for(int i=0;i<prerequisites.length;i++){
			int[] cur = prerequisites[i];
			adjList[cur[1]].add(cur[0]);
			inDegree[cur[0]]++;
		}
		List<Integer> res = new LinkedList();
		boolean[] visited = new boolean[numCourses];
		for(int i=0;i<inDegree.length;i++){
			if(inDegree[i]==0&&!visited[i]){
				dfs(i, res, inDegree, adjList, visited);
			}
		}
		if(res.size()==numCourses){
			int[] toRet = new int[res.size()];
			for(int i=0;i<toRet.length;i++)
				toRet[i] = res.get(i);
			return toRet;
		}else
			return new int[0];
		//have  avisited array
		//then recurse on it, visit each it's neighbors and then if it is 0 after decrement, then dfs on it, keep going until exhauste, then in the initial for loop ensure all things visited
	}

	public void dfs(int index, List<Integer> res, int[] inDegree, ArrayList<Integer>[] adjList, boolean[] visited){
		visited[index] = true;
		res.add(index);
		ArrayList<Integer> neighbors = adjList[index];
		for(Integer i:neighbors){
			//if neighbor not visited, then dfs only if its inDegree now is 0
			if(!visited[i]){
				if(--inDegree[i]==0)
					dfs(i, res,inDegree, adjList, visited);
			}
		}
	}
    
}