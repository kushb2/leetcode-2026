class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0] - a[0]);// max head

        for(int[] it: points){
            int x = it[0];
            int y = it[1];

            int distance = (x*x) + (y*y);
            pq.offer(new int[] { distance, x, y});

            if(pq.size() > k){
                pq.poll();
            }
        }
        List<int[]> ans = new ArrayList<>();
        while(!pq.isEmpty()){
            int[] peek = pq.poll();
            ans.add(new int[] {peek[1], peek[2]});
        }
        return ans.toArray(new int[ans.size()][2]);
    }
}