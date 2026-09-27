class Solution {
    public void dfs(Map<Integer, List<Integer>> map,boolean[] visited, int root){
        if(visited[root] == true) return;
        visited[root] = true;

        for(int it: map.get(root)){
            dfs(map, visited, it);
        }
    }
    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(i, new ArrayList<>());
        }

        for(int[] it: edges){
            map.get(it[0]).add(it[1]);
            map.get(it[1]).add(it[0]);
        }

        boolean[] visited = new boolean[n];
        int count = 0;
        for(int i=0;i<n;i++){
            if(visited[i] == false){
                count++;
                dfs(map,visited,i);
            }
        }
        return count;
    }
}
