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
        PriorityQueue<Interval> pq = new PriorityQueue<>((a,b) -> a.start - b.start);


        // flat all intervals and put into prority queue
        for(List<Interval> x: schedule){
            for(Interval y : x){
                pq.offer(y);
            }
        }

        // merge them 
        ArrayList<Interval> nonOverlappingInterval = new ArrayList<>();
        Interval prevInterval = pq.poll();
        while(!pq.isEmpty()){
            Interval curr = pq.poll();
            if(prevInterval.end >= curr.start){
                prevInterval.end = Math.max(prevInterval.end, curr.end);
            }else{
                nonOverlappingInterval.add(prevInterval);
                prevInterval = curr;
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