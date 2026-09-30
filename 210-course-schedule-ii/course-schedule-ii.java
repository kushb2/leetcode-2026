class Solution {
    public int[] findOrder(int n, int[][] prerequisites) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int[] inDegree = new int[n];
        for(int i=0;i<n;i++) adj.put(i, new ArrayList<>());

        for(int[] it: prerequisites){
            int a = it[0]; int b = it[1];
            adj.get(b).add(a);
            inDegree[a]++;
        }

        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=0;i<n;i++) 
            if(inDegree[i] == 0)
                dq.offer(i);

        int[] ans = new int[n];
        int idx = 0;
        int compCourseCount = 0;
        while(!dq.isEmpty()){
            int compCourse = dq.poll();
            compCourseCount++;
            ans[idx++] = compCourse;
            for(int it: adj.get(compCourse)){
                inDegree[it]--;
                if(inDegree[it] == 0)
                    dq.offer(it);
            }
        }

        return compCourseCount == n ? ans : new int[] {};        
    }
}