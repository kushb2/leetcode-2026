class Solution {

    Set<String> set;
    int[] dp;
    int n;
    public boolean solve(String s, int idx){
        if(idx == n) return true; // able to break arr completely no char left to break;

        if(dp[idx] != -1){
            return dp[idx] == 1 ? true : false;
        }
        
        // Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
        StringBuilder sb = new StringBuilder();
        for(int start = idx; start < n; start++){
            sb.append(s.charAt(start));

            if(set.contains(sb.toString()) && solve(s, start+1)){
                dp[idx] = 1;
                return true;
            }

        }
        dp[idx] = 0; // can not break string starting from idx index 

        return false;

    }
    public boolean wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>(wordDict);
        n = s.length();
        dp = new int[n];
        Arrays.fill(dp, -1);
        return solve(s,0);
    }
}