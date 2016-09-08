public class Solution {
    public int hIndex(int[] citations) {
        //binary search if the number of spces to the right of the index incuding the index is greter than or equal to the index then save this index and go right, else go left
        int low = 0;
        int high = citations.length-1;
        while(low<=high){
            int mid = (low+high)/2;
            
            if(citations[mid]>=citations.length-mid)
            		high = mid-1;
            else
            		low = mid+1;
        }
        return citations.length-(high+1);
    }
}