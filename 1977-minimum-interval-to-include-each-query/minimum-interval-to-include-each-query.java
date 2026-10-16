class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        // Sort then my start time . if ST is equal then sort then which ends first
        Arrays.sort(intervals, (a,b) -> {
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        int n = intervals.length, m = queries.length;
        int[][] queryWithIndex = new int[m][2];
        for(int i=0;i<m;i++) {
            queryWithIndex[i][0] = queries[i]; // value
            queryWithIndex[i][1] = i; // index
        }

        Arrays.sort(queryWithIndex,(a,b) -> a[0] - b[0]);

        int[] ans = new int[m]; 

        // peek is the one has smallest interval
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]); // len , end 

        int idx = 0; // intervals 

        for(int i=0;i<m;i++){
            int query = queryWithIndex[i][0];
            int queryIndex = queryWithIndex[i][1];

            while(idx < n && intervals[idx][0] <= query){
                int right = intervals[idx][1];
                int len = intervals[idx][1] - intervals[idx][0] + 1;
                pq.offer(new int[] { len, right});
                idx++;
            }

            while(!pq.isEmpty() && pq.peek()[1] < query){
                pq.poll();
            }

            ans[queryIndex] = pq.isEmpty() ? -1 : pq.peek()[0];

        }

        return ans;
        
    }
}