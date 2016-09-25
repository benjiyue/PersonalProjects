public class Solution {
    /*
    Idea is that you iterate the string from left to right and if a smaller the comes before  larger number then you subtract it,else you add it, you keep track of the lowest number seen thus far
    */
    public int romanToInt(String s) {
        
        if(s==null||s.length()==0)
            return 0;
        
        Map<Character, Integer> map = new HashMap();
        map.put('I',1);
        map.put('V',5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int res = 0;
        int prev = map.get(s.charAt(0));
        for(int i=1;i<s.length();i++){
            if(prev<map.get(s.charAt(i))){
                res-=prev;
            }else{
                res+=prev;
            }
            prev = map.get(s.charAt(i));
        }
        res+=prev;
        return res;
    }
}