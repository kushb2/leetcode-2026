class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] it: prerequisites){
            int a = it[0];
            int b = it[1];
            // take b before a 
            adj.get(b).add(a);
            inDegree[a]++;
        }
        Deque<Integer> q = new ArrayDeque<>();
        for(int i=0;i<numCourses;i++){
            if(inDegree[i] == 0){
                q.offer(i);
            }
        }
        List<Integer> path = new ArrayList<>();
        int count = 0;
        while(!q.isEmpty()){
            count++;
            int node = q.poll();
            path.add(node);
            for(int it: adj.get(node)){
                inDegree[it]--;
                if(inDegree[it] == 0){
                    q.offer(it);
                }
            }
        }
        return count == numCourses ? path.stream().mapToInt(x -> x).toArray() : new int[] {};
    }
}