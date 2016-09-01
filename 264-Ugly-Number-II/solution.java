public class Solution {
    public int nthUglyNumber(int n) {
        //build an array of size n
        int[] uglies = new int[n];
        uglies[0] = 1;
        int threeP = 0;
        int twoP = 0;
        int fiveP=0;
        for(int i=1;i<n;i++){
            uglies[i] = Math.min(3*uglies[threeP],Math.min(2*uglies[twoP],5*uglies[fiveP]));
            if(uglies[i]%5==0)  fiveP++;
            if(uglies[i]%3==0)  threeP++;
            if(uglies[i]%2==0)  twoP++;
        }
        return uglies[n-1];
        //have a triplet index telling you where each number has to multiply next to get minimum
        /*
        This makes sense as of course each number will point to the lowest value it has ever multiplied before, for example if i multiply something by 5, then despite the fact that there are other lower numbers, i could've never reached them, I can only reach my own lowest
        
        */
    }
}