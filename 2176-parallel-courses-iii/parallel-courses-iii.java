class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] maxTimeTake = new int[n];
        for(int i=0;i<n;i++){
            map.put(i, new ArrayList<>());
        }
        int[] inDegree = new int[n];

        for(int[] it: relations){
            map.get(it[0]-1).add(it[1]-1);
            inDegree[it[1]-1]++;
        }

        Deque<Integer> q = new ArrayDeque<>();

        for(int i = 0; i<n;i++){
            if(inDegree[i] == 0){
                q.offer(i);
            }
            maxTimeTake[i] = time[i];
        }

        while(!q.isEmpty()){
            int currCourse = q.poll();

            for(int it: map.get(currCourse)){
                maxTimeTake[it] = Math.max(
                    maxTimeTake[currCourse] + time[it] ,
                        maxTimeTake[it]
                    );
                    inDegree[it]--;
                    if(inDegree[it] == 0){
                        q.offer(it);
                    }
            }
        }

        int ans = 0;
        for(int node = 0;node<n;node++){
            ans = Math.max(ans, maxTimeTake[node]);
        }
        return ans;


    }
}