class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for(int i=0;i<n;i++) adj.put(i, new ArrayList<>());
        int[] dist = new int[n]; 
        Arrays.fill(dist, Integer.MAX_VALUE);
        for(int[] it: times){
            int u = it[0]-1; int v = it[1]-1; int time = it[2];
            adj.get(u).add(new int[] { v,time}); 
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);

        pq.offer(new int[] { k-1,0});
        int visitedCount = 0;

        while(!pq.isEmpty()){
            int[] currNode = pq.poll();
            int node = currNode[0]; int time = currNode[1];
            if(dist[node] != Integer.MAX_VALUE){
                continue;
            }
            dist[node] = time; // to reach k it take zero time 
            visitedCount++;
            if(visitedCount == n) return time;

            for(int[] it: adj.get(node)){ 
                    // I already reached to this node , as diaktra make sure 
                    // first time i reach with minimum time 
                    if(dist[it[0]] != Integer.MAX_VALUE) continue; 
                    pq.offer(new int[] { it[0], it[1] + time});
            }
        }

        return -1;



    }
}