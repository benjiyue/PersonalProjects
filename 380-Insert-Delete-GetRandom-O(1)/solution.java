import java.util.*;
public class RandomizedSet {
    /*
    idea is to maintain a map of numbers to their indices in a arraylist
    
    
    insert puts into the map and adds to the end of the list
    
    remove, removes the item from the location and remove the mapping then repalce the index with the last thing in the array and updates its new location,
    
    random returns anything from the array based on Random class
    */
    
    List<Integer> array;
    Map<Integer, Integer> map;
    Random rand;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        array = new ArrayList();
        map = new HashMap();
        rand = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val))
            return false;
        
        map.put(val, array.size());
        array.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val))
            return false;
        
        int index = map.get(val);
        //element to remove is not the last element so we need to swap the last element to the index, we also need to remove it
        if(index<array.size()-1){
            int endOfList = array.get(array.size()-1);
            array.set(index, endOfList);
            map.put(endOfList, index);
        }
        //even if i didnt hit the condition it means the element to remove is the last element so remove it anyways.element i the last so we still remove the alst
        array.remove(array.size()-1);
        //we always remove the mapping of the val
        map.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return array.get(rand.nextInt(array.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */