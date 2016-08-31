public class Solution {
    public int jump(int[] nums) {
        /*
        queue:3
        visited:0,2,1,3
        steps=2
        queueSize = 1;
        index = 1
        
        0,1,2,3,4
        2,3,1,1,4
        */
        if(nums==null||nums.length<2)
            return 0;
        
        Queue<Integer> queue = new LinkedList();
        boolean[] visited = new boolean[nums.length];
        
        queue.add(0);
        int steps = 1;
        visited[0] = true;
        while(!queue.isEmpty()){
            int queueSize = queue.size();
            while(queueSize>0){
                int index = queue.remove();
                
                for(int i=nums[index];i>0;i--){
                    if(i+index>=nums.length-1)
                        return steps;
                    if(visited[i+index])
                        break;
                    queue.add(i+index);
                    visited[i+index] = true;
                }
                queueSize--;
            }
            steps++;
        }
        return steps;
    }
}