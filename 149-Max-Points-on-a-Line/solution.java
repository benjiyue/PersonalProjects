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
        if(points==null||points.length==0)
            return 0;
        //idea is to iterate over all the points and use each as an anchor to find the slope between it and all others, if the slope is alrady in the map increment count else map it, the max will be the largest value in the set+1, then start with next;
        int maxEver = 1;
        
        for(int i=0;i<points.length;i++){
            //number of dups of i
            int dups = 0;
            int thisLevelMax = 0;
            Map<Double, Integer> map = new HashMap();
            for(int j=0;j<points.length;j++){
                if(j==i)    continue;
                if(points[j].y==points[i].y&&points[j].x==points[i].x){
                    dups++;
                    continue;
                }
                Double slope = points[j].x!=points[i].x?
                    (double)(points[j].y-points[i].y)/(double)(points[j].x-points[i].x):
                    null;
                if(!map.containsKey(slope))
                    map.put(slope, 0);
                int next = map.get(slope)+1;
                map.put(slope, next);
                thisLevelMax = Math.max(thisLevelMax, next);
            }
            maxEver = Math.max(thisLevelMax+1+dups, maxEver);
        }
        return maxEver;
    }
}