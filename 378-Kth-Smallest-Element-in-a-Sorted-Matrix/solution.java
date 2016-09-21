public class Solution {
    
    class Num{
        int row;
        int index;
        int val;
        public Num(int a, int b, int c){
            row = a;
            index = b;
            val = c;
        }
    }
    
    public int kthSmallest(int[][] matrix, int k) {
        //klogn solution involves minheap put all the row values into an object designating the row and the value, then sort based on value. Then keep popping until k at which point return. for each pop get the next index
        PriorityQueue<Num> minHeap = new PriorityQueue(new Comparator<Num>(){
            public int compare(Num a, Num b){
                return a.val-b.val;
            }
        });
        
        for(int i=0;i<matrix.length;i++)
            minHeap.offer(new Num(i, 0, matrix[i][0]));
        
        while(k>0){
            k--;
            Num nextMin = minHeap.poll();
            if(k==0)
                return nextMin.val;
            nextMin.index++;
            if(nextMin.index<matrix.length){
                nextMin.val = matrix[nextMin.row][nextMin.index];
                minHeap.offer(nextMin);
            }
        }
        return -1;
    }
    /*
    [1,  5, 9],
    [10,11,13],
    [12,13,15]]
      8
    
    */
}