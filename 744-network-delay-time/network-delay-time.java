class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for(int i=0;i<n;i++) adj.put(i, new ArrayList<>());
        int[] arr = new int[n];
        Arrays.fill(arr, -1);

        for(int[] it: times){
            int u = it[0]-1; int v = it[1]-1; int time = it[2];
            adj.get(u).add(new int[] { v,time});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> a[1] - b[1]
        );

        pq.offer(new int[] { k-1,0});

        while(!pq.isEmpty()){
            int[] currNode = pq.poll();
            int node = currNode[0]; int time = currNode[1];
            if(arr[node] != -1) continue;     
            arr[node] = time;
            for(int[] it: adj.get(node)){
                     pq.offer(new int[] { it[0], it[1] + time});
            }
        }

        int maxTime = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] == -1) return -1;
            maxTime = Math.max(maxTime, arr[i]);
        }

        return maxTime;



    }
}