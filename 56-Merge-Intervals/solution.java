/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList();
        
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b){
                    return a.start-b.start;
            }
        });
        
        for(Interval i:intervals){
            if(res.size()==0){
                res.add(i);
                continue;
            }
            Interval last = res.get(res.size()-1);
            if(i.start<=last.end){
                last.end = Math.max(last.end, i.end);
            }else{
                res.add(i);
            }
        }
        return res;
        
    }
}