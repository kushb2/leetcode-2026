class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for(char it: tasks) map.put(it, map.getOrDefault(it, 0)+1);

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        for(int it: map.values()) pq.offer(it);

        int totalTime = 0;
        while(!pq.isEmpty()){ 
            List<Integer> remTask = new ArrayList<>();
            int processedTask = 0;
            for(int i=0;i<=n && !pq.isEmpty();i++){
                processedTask++;
                int count = pq.poll();
                System.out.println(count);
                if(--count != 0) remTask.add(count);
            }
            totalTime += remTask.isEmpty() ? processedTask : n+1;
            for(int it: remTask) pq.offer(it);
            System.out.println();

        }
        return totalTime;



        
    }
}