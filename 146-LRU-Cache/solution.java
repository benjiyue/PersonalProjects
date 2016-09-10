import java.util.*;
public class LRUCache {
    
    //have a linkedlist of nodes and a hashmap yo access the doubly linkedlist. And always invalidate from the front/head. Head and tail are dummy pointers. Get simply retrieves the item and puts it to the end of the array, set checks to see whether the key is in the list if so reset the val and put to end else create new and  put to end, but if size is too big, remove from the head
    class Node{
        public Node left;
        public Node right;
        public int val;
        public int key;
    }
    
    Node head;
    Node tail;
    int capacity;
    Map<Integer, Node> map;
    
    public LRUCache(int capacity) {
        head = new Node();
        tail = new Node();
        head.right = tail;
        tail.left = head;
        this.capacity = capacity;
        map = new HashMap();
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node temp = map.get(key);
            removeNode(temp.left, temp.right);
            putToEnd(temp);
            return temp.val;
        }else
            return -1;
    }
    
    public void set(int key, int value) {
        Node newNode;
        if(map.containsKey(key)){
            newNode = map.get(key);
            newNode.val = value;
            removeNode(newNode.left, newNode.right);
            putToEnd(newNode);
        }else{
            newNode = new Node();
            newNode.val = value;
            newNode.key = key;
            map.put(key, newNode);
            
            if(capacity==0){
                Node toRemove = head.right;
                map.remove(toRemove.key);
                removeNode(head, head.right.right);
                capacity++;
            }
            putToEnd(newNode);
            capacity--;
        }
            
    }
    
    //remove the node between left nd right
    public void removeNode(Node left, Node right){
        Node toRemove = left.right;
        left.right = right;
        right.left = left;
        return;
    }
    
    public void putToEnd(Node n){
        Node before = tail.left;
        before.right = n;
        n.right = tail;
        tail.left = n;
        n.left = before;
    }
}