/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> intervals = new ArrayList<>();

        // flat all intervals
        for(List<Interval> x: schedule){
            for(Interval y : x){
                intervals.add(y);
            }
        }

        intervals.sort((a,b) -> Integer.compare(a.start, b.start)); 
        int n = intervals.size();


        // merge them 
        Interval prevInterval = intervals.get(0);

        ArrayList<Interval> nonOverlappingInterval = new ArrayList<>();

        for(int i=1;i<n;i++){
            if(prevInterval.end >= intervals.get(i).start){
                prevInterval.end = Math.max(prevInterval.end, intervals.get(i).end);
            }else{
                nonOverlappingInterval.add(prevInterval);
                prevInterval = intervals.get(i);
            }
        }
        nonOverlappingInterval.add(prevInterval);

        List<Interval> freeIntervals = new ArrayList<>();

        for(int i=1;i<nonOverlappingInterval.size();i++){
            int start = nonOverlappingInterval.get(i-1).end;
            int end = nonOverlappingInterval.get(i).start;

            if(end - start > 0){
                freeIntervals.add(new Interval(start, end));
            }
        }
        return freeIntervals;


        
    }
}