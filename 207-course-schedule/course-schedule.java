class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for(int i=0;i<numCourses;i++){
            adj.put(i, new ArrayList<>());
        }
        for(int[] it: prerequisites){
            int a = it[0];
            int b = it[1];
            adj.get(b).add(a);
            inDegree[a]++;
        }

        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=0;i<numCourses;i++){
            if(inDegree[i] == 0){
                dq.offer(i);
            }
        }

        while(!dq.isEmpty()){
            int completedCourse = dq.poll(); // completed course 
            for(int it: adj.get(completedCourse)){
                inDegree[it]--;
                if(inDegree[it] == 0){
                    dq.offer(it);
                }
            }
        }

        for(int i=0;i<numCourses;i++){
            if(inDegree[i] != 0){
                return false;
            }
        }
        return true;



        
    }
}