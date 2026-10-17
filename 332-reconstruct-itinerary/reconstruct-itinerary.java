class Solution {
    public void dfs(String node, Map<String, PriorityQueue<String>> adj,List<String> ans){

        
        PriorityQueue<String> pq = adj.getOrDefault(node, new PriorityQueue<>());
        while(!pq.isEmpty()){
            dfs(pq.poll(), adj, ans);
        }
        ans.addFirst(node);
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        int n = tickets.size();

        Map<String, PriorityQueue<String>> adj = new HashMap<>();

        for(List<String> it: tickets){
            String from = it.get(0);
            String to = it.get(1);
            adj.putIfAbsent(from, new PriorityQueue<>());
            adj.get(from).offer(to);
        }

        List<String> ans = new ArrayList<>();

        dfs("JFK", adj,ans);

        return ans;
    }
}