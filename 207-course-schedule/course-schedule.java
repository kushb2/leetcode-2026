class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] inDegree = new int[numCourses];

        for(int i=0;i<numCourses;i++){
            map.put(i, new ArrayList<>());
        }

        for(int[] it: prerequisites){
            map.get(it[1]).add(it[0]);
            inDegree[it[0]]++;
        }

        Deque<Integer> q = new ArrayDeque<>();
        for(int i=0;i<numCourses;i++){
            if(inDegree[i] == 0){
                q.offer(i);
            }
        }
        int courseTaken = 0;
        while(!q.isEmpty()){
            int course = q.poll();
            courseTaken++;

            for(int it: map.get(course)){
                inDegree[it]--;
                if(inDegree[it] == 0){
                    q.offer(it);
                }
            }
        }
        return courseTaken == numCourses ? true: false;

        
    }
}