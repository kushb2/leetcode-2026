class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        Map<Integer, List<int[]>> adj = new HashMap<>();
        for(int i=0;i<n;i++) adj.put(i, new ArrayList<>());

        for(int[] it: flights){
            int u = it[0], v = it[1], wt = it[2];
            adj.get(u).add(new int[] { v, wt});
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] { src, 0, -1}); // node , dist, steps
        dist[src] = 0; // cost 0;

        while(!q.isEmpty()){
            int[] city = q.poll();
            int node = city[0], cost = city[1], steps = city[2];

            for(int[] it: adj.get(node)){
                int v = it[0], wt = it[1];

                if(steps+1 <= k &&  wt + cost < dist[v]){
                    dist[v] = wt+cost;
                    q.offer(new int[] { v, wt + cost, steps+1 });
                }
            }
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];


    }
}