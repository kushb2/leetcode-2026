class Solution {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        int[] inDegree = new int[n];
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        for(int i=0;i<n;i++) adj.put(i, new HashSet<>());
        for(int[] it: prerequisites){
            int a = it[0], b = it[1]; //a -> b
            adj.get(a).add(b);
            inDegree[b]++;
        }

        Queue<Integer> q = new ArrayDeque<>();
        for(int i=0;i<n;i++)
            if(inDegree[i] == 0)
                q.offer(i);
         
        Map<Integer, Set<Integer>> dep = new HashMap<>();
        for(int i=0;i<n;i++) dep.put(i, new HashSet<>());
        // key depdendent, preriquisite on which courses 

        while(!q.isEmpty()){
            int course = q.poll();
            for(int it: adj.get(course)){
                dep.get(it).add(course);
                // find course prerequite as well 
                for(int i : dep.get(course)){
                    dep.get(it).add(i);
                }
                inDegree[it]--;
                if(inDegree[it] == 0){
                   q.offer(it);
                }
            }
        }

        List<Boolean> ans = new ArrayList<>();
        for(int[] it: queries){
            int u = it[0], v = it[1]; // u is pre of v
            ans.add(dep.get(v).contains(u));
        }
        return ans;


         
    }
}