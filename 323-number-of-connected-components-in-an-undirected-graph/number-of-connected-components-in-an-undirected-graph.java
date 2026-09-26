class Solution {
    public void dfs(List<List<Integer>> adj,boolean[] visited, int root){
        if(visited[root] == true) return;
        visited[root] = true;

        for(int it: adj.get(root)){
            dfs(adj, visited, it);
        }

    }
    public int countComponents(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] it: edges){
            adj.get(it[0]).add(it[1]);
            adj.get(it[1]).add(it[0]);
        }

        int count = 0;
        for(int i=0;i<n;i++){
            if(visited[i] == false){
                count++;
                dfs(adj, visited, i);
            }
        }        
        return count;


    }
}