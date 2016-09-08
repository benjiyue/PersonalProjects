public class Solution {
    //[3, 0, 6, 1, 5]
    public int hIndex(int[] citations) {
        if(citations==null||citations.length==0)
            return 0;
        int[] hIndex = new int[citations.length+1];
        //create hIndex array of same size as citations and each value at each index i serves as the number of papers with at least that many citations
        for(int i=0;i<citations.length;i++){
            if(citations[i]>citations.length)
                hIndex[hIndex.length-1]++;
            else
                hIndex[citations[i]]++;
        }
        
        //accumulate from the right->left
        for(int i=hIndex.length-2;i>=0;i--)
            hIndex[i]+=hIndex[i+1];
            
        //go from right to left to find the first time the value is >= the index
        for(int i=hIndex.length-1;i>=0;i--){
            if(hIndex[i]>=i)
                return i;
        }
        return 0;
        //5,4,3,3,2,2
        //0,1,2,3,4,5
        
    }
}