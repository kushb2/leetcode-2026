class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        PriorityQueue<Double> pq = new PriorityQueue<>();
        for(int i=0;i<dist.length;i++){
            pq.offer((double)dist[i]/ speed[i]);
        }
        int count = 0, time = 0;
        while(!pq.isEmpty()){
            double mosterArriveAt = pq.poll();
            if(mosterArriveAt > time){
               count++;
               time++;
            }else{
                return count;
            }
        }
        return count;
        
    }
}

// time = distance / speed
// 1 , 3 , 4 
//3

// 1 1 2 3 
// 1 

// 0.5 , 0.7
// 1