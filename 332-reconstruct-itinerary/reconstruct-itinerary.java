class Solution {
    public void dfs(String node, Map<String, PriorityQueue<String>> map, List<String> ans){

        PriorityQueue<String> pq = map.getOrDefault(node, new PriorityQueue<>());
        while(!pq.isEmpty()){
            dfs(pq.poll(), map, ans);    
        }
         ans.addFirst(node);
        
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> ans = new ArrayList<>();
        Map<String, PriorityQueue<String>> map = new HashMap<>();

        for(List<String> it: tickets){
            map.putIfAbsent(it.get(0), new PriorityQueue<>());
            map.get(it.get(0)).offer(it.get(1));
        }

        dfs("JFK", map,ans);

        return ans;
    }
}

