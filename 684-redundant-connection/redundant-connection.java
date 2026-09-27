class Solution {
    int getParent(int[] parent, int x){
        while (x != parent[x]) {
            x = parent[x];
        }
        return x;
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
        }

        for(int[] it: edges){
            int parentA = getParent(parent, it[0]-1);
            int parentB = getParent(parent, it[1]-1);

            if(parentA == parentB){
                return it;
            }
            parent[parentA] = parentB;
        }

        return new int[] {};
        
    }
}