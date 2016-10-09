public class Solution {
    public List<Integer> grayCode(int n) {
        /*
        idea is to initially start with a 0,1 then each time we first copy the list and then reverse it. But for the reversed half we go to the iter bit and flip it to 1
        */
        
        List<Integer> prev = new ArrayList();
        prev.add(0);
        if(n==0)
            return prev;
        prev.add(1);
        for(int i=2;i<=n;i++){
            List<Integer> current = new ArrayList(prev);
            Collections.reverse(prev);
            int toOr = 1<<(i-1);
            for(int j=0;j<prev.size();j++){
                current.add(prev.get(j)|toOr);
            }
            prev = current;
        }
        return prev;
    }
}