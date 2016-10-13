public class Solution {
    public int candy(int[] ratings) {
        /*
        idea is to iterate through and at each point if im greater than both my sides then my value is max(left, right)+1
        else im greater than 1 side and my value is +1 of that side
        else im less than both so just remain 1
        */
        
        if(ratings.length==0)
            return 0;
        
        int[] candy = new int[ratings.length];
        Arrays.fill(candy, 1);
        
        //left to right
        for(int i = 1;i<candy.length;i++){
            if(ratings[i]>ratings[i-1])
                candy[i] = candy[i-1]+1;
        }
        
        //right to left
        for(int i=ratings.length-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                candy[i] = Math.max(candy[i], candy[i+1]+1);
            }
        }
        int sum = 0;
        for(int i:candy)
            sum+=i;
        return sum;
    }
}