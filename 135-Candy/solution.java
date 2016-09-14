public class Solution {
    public int candy(int[] ratings) {
        //i'm giving him the max(already, and other person's candy+1)
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);
        for(int i=1;i<ratings.length;i++){
            if(ratings[i]>ratings[i-1])
                candies[i] = Math.max(candies[i-1]+1, candies[i]);
        }
        for(int i=ratings.length-2;i>=0;i--){
            if(ratings[i]>ratings[i+1])
                candies[i] = Math.max(candies[i+1]+1, candies[i]);
        }
        int sum = 0;
        for(int i=0;i<ratings.length;i++)
            sum+=candies[i];
        
        return sum;
        
        /*
         1,2,3,1,2
        [3,4,5,1,3]
         1,2,3,1,2
        */
    }
}