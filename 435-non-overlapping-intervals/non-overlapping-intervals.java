class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        if(n <= 1) return 0;
        Arrays.sort(intervals, (a,b) -> a[1] - b[1]);

        int prevIntervalEndTime = intervals[0][1];
        int overlapCount = 0;
        for(int i=1;i<n;i++){
            if(prevIntervalEndTime > intervals[i][0]){ // 5 5 
                overlapCount++;
            }else{
                prevIntervalEndTime = intervals[i][1];
            }
        }
        // Your code goes here
        return overlapCount;
        
    }
}