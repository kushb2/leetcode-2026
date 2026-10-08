class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Arrays.fill(ans, 0);
        Stack<int[]> st = new Stack<>(); // temp and index

        for(int i=0;i<n;i++){
            while(!st.isEmpty() && st.peek()[0] < temperatures[i]){
                // find warmer days 
                int index = st.pop()[1];
                ans[index] = i - index;
            }

            st.add(new int[] { temperatures[i], i});
        }



        return ans;
    }
}