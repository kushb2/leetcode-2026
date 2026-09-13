class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();

        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

        int start = intervals[0][0];
        int end = intervals[0][1];

        for(int[] arr : intervals) {
            int currStart = arr[0];
            int currEnd = arr[1];

            if(currStart <= end){
                // can merge 
                end = Math.max(end, currEnd);
            }else{
                list.add(new int[] { start, end});
                start = currStart;
                end = currEnd;
            }

        }
        list.add(new int[] { start, end});
        return list.toArray(new int[list.size()][2]);
    }
}