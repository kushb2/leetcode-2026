class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(i, new ArrayList<>());
        }
        int[] inDegree = new int[n];
        int[] minSemNeeded = new int[n];

        for(int[] it: relations){
            map.get(it[0]-1).add(it[1]-1);
            inDegree[it[1]-1]++;
        }

        Deque<Integer> q = new ArrayDeque<>();

        for(int i=0;i<n;i++){
            if(inDegree[i] == 0){// ith course has no depdency 
                q.add(i);
            }
            minSemNeeded[i] = 1;// intially each course can take 1 sem to complete
        }

        while(!q.isEmpty()){
            int currCourse = q.poll();

            // look at all its depdency 
            for(int it: map.get(currCourse)){

                minSemNeeded[it] = Math.max(
                    minSemNeeded[it],
                minSemNeeded[currCourse] + 1
                );

                inDegree[it]--; // one depdency removed
                if(inDegree[it] == 0){
                    q.offer(it);
                }
            }

            
        }
        int ans = 0;
        

        for(int i=0;i<n;i++){
            if(inDegree[i] != 0) return -1;
            ans = Math.max(ans, minSemNeeded[i]);
        }
        return ans;
        
    }
}