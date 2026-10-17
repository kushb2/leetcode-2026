class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        Arrays.sort(flowers, (a,b) -> a[0] - b[0]);
        int m = people.length;
        int[][] peopleWithIndex = new int[m][2];
        for(int i=0;i<m;i++){
            peopleWithIndex[i][0] = people[i];
            peopleWithIndex[i][1] = i;
        }
        Arrays.sort(peopleWithIndex, (a,b) -> a[0] - b[0]);

        // add to PQ if flower start blooming before people i came 
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int idx = 0, n = flowers.length;
        int[] ans = new int[m];
        for(int[] it: peopleWithIndex){
            int time = it[0];
            int index = it[1];
            // before finding ans for i , remove the one which and ended the bloom
            while(idx < n && flowers[idx][0] <= time){
                pq.offer(flowers[idx][1]);
                idx++;
            } 

            while(!pq.isEmpty() && pq.peek() < time){
                pq.poll(); // this flower is stale as it start blooming before time and ended before time as well 
            }

            ans[index] = pq.size();

        }

        return ans;


        // remain element count is ans for i 
    }
}