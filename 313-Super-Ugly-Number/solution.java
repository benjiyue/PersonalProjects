public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        //the idea is that you create auxillary space to store the index each prime's next highest value to multiply, then on each iteration get the minimm value then iterate again to find anything that can mod the new multiple and increment it too
        int[] res = new int[n];
        res[0] = 1;
        int[] positionToMult = new int[primes.length];
        for(int i=1;i<n;i++){
            int min = Integer.MAX_VALUE;
            for(int a=0;a<primes.length;a++)
                min = Math.min(primes[a]*res[positionToMult[a]], min);
            res[i] = min;
            for(int a=0;a<primes.length;a++){
                if(min%(primes[a]*res[positionToMult[a]])==0)
                    positionToMult[a]++;
            }
        }
        return res[res.length-1];
    }
    /*
    [2, 7, 13, 19] primes
    [2, 0, 0,  0] positionToMult
    [1,2,4]n==3
    
    */
}