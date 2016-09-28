/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        /*
        idea is that for each point we must iterate over all the other points and get the slope, then map this into a hasmap between slope and count of points on that slope
        
        we must also keep track of the same point as the anchor point and add this to all lines
        
        also points with 0 divisor need to be mapped to null
        
        */
        
        if(points==null||points.length==0)
            return 0;
            
        int maxEver = 1;
        
        for(int i=0;i<points.length;i++){
            int thisMaxEver = 1;
            Map<Double, Integer> map = new HashMap();
            int dups = 0;
            for(int j=0;j<points.length;j++){
                if(i==j)
                    continue;
                if(points[i].x==points[j].x&&points[i].y==points[j].y){
                    dups++;
                    continue;
                }
                Double slope = (points[i].x-points[j].x==0)?null:(double)(points[i].y-points[j].y)/(double)(points[i].x-points[j].x);
                if(!map.containsKey(slope)){
                    map.put(slope, 2);
                    thisMaxEver = Math.max(2, thisMaxEver);
                }
                else{
                    int newVal = map.get(slope)+1;
                    map.put(slope, newVal);
                    thisMaxEver = Math.max(newVal, thisMaxEver);
                }
            }
            maxEver = Math.max(maxEver, thisMaxEver+dups);
        }
        
        return maxEver;
    }
}