public class LRUCache {
    /*
    Idea is to map values to node objects which are connecred via a linkedlist. with the front being oldest and end/right being newest thing and whenever we set an object, we check 
    */
    
    class ListNode{
        int key;
        int val;
        ListNode prev;
        ListNode next;
        public ListNode(int a, int b){
            key = a;
            val = b;
        }
    }
    
    ListNode begin;
    ListNode end;
    int size;
    Map<Integer, ListNode> map;
    public LRUCache(int capacity) {
        begin = new ListNode(0,0);
        end = new ListNode(0,0);
        begin.next = end;
        end.prev = begin;
        size = capacity;
        map = new HashMap();
    }
    
    public int get(int key) {
        ListNode gotten = map.get(key);
        if(gotten!=null){
            remove(gotten.prev, gotten.next);
            putToBack(gotten);
        }
        return gotten==null?-1:gotten.val;
    }
    
    /*
    check to see if the key is already in the map if it is its simply giving it a new value
    else it's new so create a new node. if over the size then remove the frontmost node from the map ie front.next; and also from the list
    
    In with case move it to the end afterwards.
    */
    public void set(int key, int value) {
        ListNode gotten = map.get(key);
        //new insertion maybe need to resize
        
        if(gotten==null){
            ListNode newNode = new ListNode(key, value);
            map.put(key, newNode);
            if(size==0){
                ListNode oldest = begin.next;
                map.remove(oldest.key);
                remove(begin, oldest.next);
                size++;
            }
            putToBack(newNode);
            size--;
        }
        //already exists
        else{
            gotten.val = value;
            remove(gotten.prev, gotten.next);
            putToBack(gotten);
        }
    }
    
    //remove node given access to its neighbors
    public void remove(ListNode before, ListNode after){
        before.next = after;
        after.prev = before;
    }
    
    //insert to the back
    public void putToBack(ListNode in){
        ListNode beforeLast = end.prev;
        beforeLast.next = in;
        in.next = end;
        in.prev = beforeLast;
        end.prev = in;
    }
}