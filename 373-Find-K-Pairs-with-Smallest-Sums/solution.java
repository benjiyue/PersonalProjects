public class Solution {
    
    class Pair{
        int nums1Index;
        int nums2Index;
        int sum;
        public Pair(int a, int b, int c){
            nums1Index = a;
            nums2Index = b;
            sum = c;
        }
    }
    
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        //idea is to make a min heap of objects that are rooted at each number in nums1 and each has a pointer to nums2, then each time pop from the heap and move up the num2 pointer. stop when k==0 and return the two indices
        
        List<int[]> res = new LinkedList();
        
        if(nums1==null||nums2==null||nums1.length==0||nums2.length==0)
            return res;
        
        if(k<=0)
            return res;
            
        PriorityQueue<Pair> minHeap = new PriorityQueue(new Comparator<Pair>(){
            public int compare(Pair a, Pair b){
                return a.sum-b.sum;
            }
        });
        for(int i=0;i<nums1.length;i++)
            minHeap.offer(new Pair(i,0,nums1[i]+nums2[0]));
        
        while(k>0&&!minHeap.isEmpty()){
            Pair nextPair = minHeap.poll();
            k--;
            res.add(new int[]{nums1[nextPair.nums1Index], nums2[nextPair.nums2Index]});
            nextPair.nums2Index++;
            if(nextPair.nums2Index<nums2.length){
                nextPair.sum = nums1[nextPair.nums1Index]+nums2[nextPair.nums2Index];
                minHeap.offer(nextPair);
            }
        }
        return res;
    }
    /*
    
    [1,2], nums2 = [3] k=3;
    minHeap:
    [1,3],[2,3]
    
    */
}