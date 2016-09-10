public class Solution {
    boolean firstTime = true;
    int[] combos = new int[11];
    public int countNumbersWithUniqueDigits(int n) {
        if(firstTime){
            combos[0] = 1;
            combos[1]= 10;
            combos[2] = 9*9+10;
            
            int totalEver = 9*9+10;
            int thisLevel = 9*9;
            int next = 8;
            for(int i=3;i<=10;i++){
                thisLevel*=next--;
                totalEver+=thisLevel;
                combos[i] = totalEver;
            }
            firstTime = false;
        }
        return n<=10?combos[n]:combos[10];
    }
}