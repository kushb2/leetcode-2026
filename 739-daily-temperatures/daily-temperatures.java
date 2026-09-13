class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // monotically descrsing 
        Stack<Integer> st = new Stack<>();
        int n = temperatures.length;
        int[] ans = new int[n];
        Arrays.fill(ans,0);
        for(int i=0;i<n;i++){
            int curr = temperatures[i];

            while(!st.empty() && temperatures[st.peek()] < curr){
                // find wamer days for st.top 
                ans[st.peek()] = i - st.peek();
                st.pop();
            }

            st.push(i);

        }
        return ans;
    }
}