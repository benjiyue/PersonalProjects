public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        /*
            we accumulate the excess gas we have at every step and calcualte the amount needed to get from here to the next based on gas[i]-cost[i]. If the difference between this and the excess if negative we start at the next index of where we're currently iterating. else we continue and subtract the values
                  i
                  t
             1, 1,11 gas
            -3,-4,10 diff
             4, 5, 1 cost
            surplus = 3
            
        */
        
        int surplus = 0;
        int index=0;
        while(index<gas.length){
            int temp = index;
            while(temp!=index+gas.length){
                int diff = gas[temp%cost.length]-cost[temp%cost.length];
                if(surplus+diff<0){
                    index = temp+1;
                    break;
                }
                surplus+=diff;
                temp++;
            }
            if(temp==index+cost.length){
                return index;
            }
        }
        return -1;
    }
}