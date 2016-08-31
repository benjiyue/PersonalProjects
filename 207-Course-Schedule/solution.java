public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        //create the adj matrix
        List<Integer>[] adjMatrix = new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++){
            adjMatrix[i]= new ArrayList<Integer>();
        }
        
        int[] in = new int[numCourses];
        
        for(int i=0;i<prerequisites.length;i++){
            adjMatrix[prerequisites[i][1]].add(prerequisites[i][0]);
            in[prerequisites[i][0]]++;
        }
        
        boolean[] visited = new boolean[numCourses];
        
        //do dfs
        Queue<Integer> queue = new LinkedList();
        for(int i=0;i<numCourses;i++){
            if(in[i]==0)
                queue.add(i);
        }
        int visitedCount = 0;
        while(!queue.isEmpty()){
            int popped = queue.remove();
            if(visited[popped]) continue;
            visited[popped] = true;
            visitedCount++;
            for(Integer i:adjMatrix[popped]){
                in[i]--;
                if(!visited[i]&&in[i]==0)
                    queue.add(i);
            }
        }
        
        return visitedCount==numCourses;
    }
}