public class Solution {
    public boolean increasingTriplet(int[] nums) {
        int[] triple = new int[3];
        //create array repreneting the lowest number possible for the increasing subsequence with length index
        
        //now iterate through the array and put find the location where triplet[i-1]<the number<triplet[i], and update the index to the new number shich is guaranteed to be smaller
        int longest = 0;
        for(Integer i:nums){
            int a = 0;
            for(;a<longest;a++){
                if(a+1>longest||i<=triple[a])
                    break;
            }
            triple[a] = i;
            if(a==longest)
                longest++;
            if(longest==3)
                return true;
        }
        return false;
    }
}