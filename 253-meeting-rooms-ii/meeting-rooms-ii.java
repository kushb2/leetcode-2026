class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        int[] starts = new int[n];
        int[] ends = new int[n];

        for(int i=0;i<n;i++){
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }

        Arrays.sort(starts);
        Arrays.sort(ends);
        
        int i =0, j =0;
        int meetingRoom = 0;
        int maxRoom = 0;
        while(i < n || j < n){
            int a = i<n ? starts[i] : Integer.MAX_VALUE;
            int b = j<n ? ends[j] : Integer.MAX_VALUE;

            if( a < b){
                meetingRoom++;
                i++;
            }else{
                meetingRoom--;
                j++;
            }
            maxRoom = Math.max(maxRoom,meetingRoom);

        }
        return maxRoom;
    }
}