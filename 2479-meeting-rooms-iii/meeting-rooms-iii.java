class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a,b) -> a[0] - b[0]);
        PriorityQueue<Integer> availableRoom = new PriorityQueue<>();
        int[] meetingCount = new int[n];
        for(int i=0;i<n;i++){
            availableRoom.offer(i); // all rooms are present 
        }
        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b) -> {
            if(a[0] == b[0]){ // end time is equal
               return Long.compare(a[1],b[1]); // whcih has min room 
            }
            return Long.compare(a[0],b[0]);
        });

       

        for(int i=0;i<meetings.length;i++){
            int start = meetings[i][0];
            int end = meetings[i][1];

            while(!pq.isEmpty() && pq.peek()[0] <= start){
               long[] it =  pq.poll();
               availableRoom.offer((int)it[1]);
            }
            
            if(availableRoom.isEmpty()){
                long[] it = pq.poll();
                long meetingEnd = it[0];
                int room = (int)it[1];
                long newMeetingEndAt = end + (meetingEnd - start);
                meetingCount[room]++;
                pq.offer(new long[] {  newMeetingEndAt, room});
            }else{
                int room = availableRoom.poll();
                meetingCount[room]++;
                pq.offer(new long[] { end, room});
            }
            
        }

        int ans = 0, count = -1;
        for(int i=0;i<meetingCount.length;i++){
            if(meetingCount[i] > count){
                count = meetingCount[i];
                ans = i;
            }
        }

        return ans;

        
    }
}