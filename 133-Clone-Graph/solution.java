/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        /*
        copy a undirected graph given a node in the graph
        
        we do a dfs on the graph each time keeping the set of visited nodes so we dont go in circles then at each step we add to the hashmap the neightbors of each node. after visiting everyone we create new nodes from the keys and put them in a map from node value to node object then attaches the neighbors using the values in the map
        
       1
      / \
     /   \
    0 --- 2
         / \
         \_/
        
        set:1,0,2
        1->0,2
        0->1,2
        2->1,0,2
        
        */
        if(node==null)
            return node;
        Set<UndirectedGraphNode> visited = new HashSet();
        Map<Integer, List<Integer>> map = new HashMap();
        dfs(node, visited, map);
        
        
        Map<Integer, UndirectedGraphNode> nodeMap = new HashMap();
        for(Integer key:map.keySet()){
        	nodeMap.put(key, new UndirectedGraphNode(key));
        }
        for(Integer value:nodeMap.keySet()){
            List<UndirectedGraphNode> myNeighbors = nodeMap.get(value).neighbors;
            List<Integer> neighbors = map.get(value);
            for(Integer neighbor:neighbors)
                myNeighbors.add(nodeMap.get(neighbor));
        }
        
        return nodeMap.get(node.label);
    }
    
    public void dfs(UndirectedGraphNode root, Set<UndirectedGraphNode> visited, Map<Integer, List<Integer>> map){
        visited.add(root);
        
        map.put(root.label, new LinkedList<Integer>());
        List<Integer> neighbors = map.get(root.label);
        
        for(UndirectedGraphNode neighbor:root.neighbors){
            neighbors.add(neighbor.label);
            if(!visited.contains(neighbor)){
                dfs(neighbor, visited, map);
            }
        }
        
    }

}