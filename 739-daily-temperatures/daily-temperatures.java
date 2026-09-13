class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // monotically descrsing 
        Deque<Integer> st = new ArrayDeque<>();
        int n = temperatures.length;
        int[] ans = new int[n];
        Arrays.fill(ans,0);
        for(int i=0;i<n;i++){
            int curr = temperatures[i];

            while(!st.isEmpty() && temperatures[st.peek()] < curr){
                // find wamer days for st.top 
                ans[st.peek()] = i - st.peek();
                st.pop();
            }

            st.push(i);

        }
        return ans;
    }
}