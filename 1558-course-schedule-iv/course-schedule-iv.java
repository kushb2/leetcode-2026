class Solution {
    public void dfs( Map<Integer, Set<Integer>> adj, Set<Integer> dep, int start){

        for(var it: adj.get(start)){
            dep.add(it);
            dfs(adj, dep, it);
        }
    }
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        for(int i=0;i<n;i++) adj.put(i, new HashSet<>());
        for(int[] it: prerequisites){
            int a = it[0], b = it[1]; //a -> b
            adj.get(a).add(b);
        }
         Map<Integer, Set<Integer>> depMap = new HashMap<>();
         for(int i=0;i<n;i++){
            Set<Integer> dep = new HashSet<>();
            dfs(adj, dep, i);
            depMap.put(i, dep);
         }

         List<Boolean> ans = new ArrayList<>();
         for(int[] it: queries){
            ans.add(depMap.get(it[0]).contains(it[1]));
         }
        return ans;
    }
}