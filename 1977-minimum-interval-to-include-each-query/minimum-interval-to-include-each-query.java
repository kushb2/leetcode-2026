class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        // Sort Interval by start time , why => so for each query we start from left and stop as soon as we find
        // first interval which is right outside of query 
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        // Sort query so for each next query we can start from the interval where we left , as we already cover all interval which start from the next query . 
        // exampl 2, 3 => when we reach 3 we have already have all interval which valid for 2 , so they can be valid for 3 .or start before 3. 
        int[][] queriesAndIndex = new int[queries.length][2];
        for(int i=0;i<queries.length;i++){
            queriesAndIndex[i][0] = queries[i]; // value
            queriesAndIndex[i][1] = i; // index
        } 
        Arrays.sort(queriesAndIndex, (a,b) -> a[0] - b[0]);

        // we need a priority queue as min heap , which on peek store out of all intervals , interval with the min distance 
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        int[] ans = new int[queries.length];
        int intervalIndex = 0;
        for(int[] it: queriesAndIndex){ // consider all query 
            int query = it[0];
            int queryIndex = it[1];

            // for each query , consider all the valid interval which start before query 
            while(intervalIndex < intervals.length){
                int[] interval = intervals[intervalIndex];
                int start = interval[0];
                int end = interval[1];
                int distance = end - start + 1;
                if(start <= query){ // can be a valid interval
                    pq.offer(new int[] { distance, end});// we need end because for each new query we first need to remove interval which end before query start. they start before query but end before it as well 
                    intervalIndex++; // move to next interval as this one is considered 
                }else{
                    break; // can not move it futher in intervals . 
                }
            }

            // now remove all interval which end before query start . why we doing this seperate as for each new increment query we anyway need to do that 
            while(!pq.isEmpty() && pq.peek()[1] < query){ // peek element is ended before query start invalid
                pq.poll();
            }

            // we looking at valid intervals and peek will have interval with sortest length 
            ans[queryIndex] = pq.isEmpty() ? -1 : pq.peek()[0];

        }
        return ans;

        
    }
}