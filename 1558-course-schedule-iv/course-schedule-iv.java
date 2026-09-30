class Solution {
    public boolean dfs( Map<Integer, Set<Integer>> adj, int start, int end){
        if(start == end) return true;

        for(var it: adj.get(start)){
            if(dfs(adj, it, end)) return true;
        }
        return false;
    }
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        for(int i=0;i<n;i++) adj.put(i, new HashSet<>());
        for(int[] it: prerequisites){
            int a = it[0], b = it[1]; //a -> b
            adj.get(a).add(b);
        }
        List<Boolean> ans = new ArrayList<>();
        for(int[] it: queries){
           boolean found =  dfs(adj, it[0], it[1]);
           ans.add(found);
        }
        return ans;
    }
}