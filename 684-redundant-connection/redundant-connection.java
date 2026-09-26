class Solution {
    int findRoot(int[] parent, int x){
        while(parent[x] != x){
            x = parent[x];
        }
        return x;
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;// index is 1 
        int[] parent = new int[n+1];

        for(int i=1;i<=n;i++){
            parent[i] = i;
        }

        for(int[] it: edges){
            int a = it[0];
            int b = it[1];

            int rootA = findRoot(parent, a);
            int rootB = findRoot(parent, b);

            if(rootA == rootB){
                return it;
            }
            parent[rootA] = rootB;
        }
        return new int[] {};

    }
}