public class Solution {
    public boolean isIsomorphic(String s, String t) {
        /*
        make an 256 array that tells us what the replacement shold be
        */
        
        Character[] sToT = new Character[256];
        Character[] tToS = new Character[256];
        for(int i=0;i<s.length();i++){
            Character sToTCurrent = sToT[s.charAt(i)];
            Character tToSCurrent = tToS[t.charAt(i)];
            //if there was a mapping before make sure that you are only repalceing with the same cannot repalce with new for either that's non null
            if(sToTCurrent!=null&&sToTCurrent!=t.charAt(i)) return false;
            if(tToSCurrent!=null&&tToSCurrent!=s.charAt(i)) return false;

            sToT[s.charAt(i)] = t.charAt(i);
            tToS[t.charAt(i)] = s.charAt(i);
        }
        
        return true;
    }
}