class Solution {
    public int minMeetingRooms(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        for(int[] it: intervals){
            list.add(new int[] { it[0], 1});
            list.add(new int[] { it[1], 0});
        }

        list.sort((a,b) -> {
        if(a[0] != b[0]){
            return a[0] - b[0];
        }

        return a[1] - b[1];

    });
       
        int meetingRoom = 0, maxRoom = 0;
        for(int[] it: list){
            // 1 13 13 15
            int action = it[1];
            if(action == 1){
                meetingRoom++;
            }else{
                meetingRoom--;
            }

            maxRoom = Math.max(meetingRoom, maxRoom);

        }

        return maxRoom;
        
    }
}