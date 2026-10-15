class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        int n = intervals.length;

        int idx = 0;

        // lets cosider all interval which ends before new interval starts 
        while(idx < n && intervals[idx][1] < newInterval[0]){
            ans.add(intervals[idx]);
            idx++;
        }

        // if i th intervals starts before new interval ends 
        while(idx < n && intervals[idx][0] <= newInterval[1]){
            newInterval[0] = Math.min(newInterval[0], intervals[idx][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[idx][1]);
            idx++;
        }

        ans.add(newInterval);

        // all interval which start after new interval ends 
        while(idx < n && intervals[idx][0] > newInterval[1]){
            ans.add(intervals[idx]);
            idx++;
        }
        return ans.toArray(new int[ans.size()][2]);
    }

    
}

// i th intedrval end time < i+1 interval start time 
//