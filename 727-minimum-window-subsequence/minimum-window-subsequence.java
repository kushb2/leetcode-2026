class Solution {
    int INF = (int)1e9;
    public int solve(String s1, String s2, int i, int j,int[][] dp){
        if(j == s2.length()) return 0;
        if(i == s1.length()) return INF;
        
        if(dp[i][j] != -2) return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = 1 + solve(s1, s2, i+1, j+1,dp);
        }else{
            return dp[i][j] = 1 + solve(s1, s2, i+1, j,dp);
        }

    }
    public String minWindow(String s1, String s2) {
        int n = s1.length(), m = s2.length();

        // every valid subSequence will start from some index 
        int minLen = Integer.MAX_VALUE;
        String ans = "";
        int[][] dp = new int[n][m];
        for(int[] it: dp) Arrays.fill(it, -2);
        for(int left = 0; left<n;left++){

            if(s1.charAt(left) != s2.charAt(0)) continue;

            int len = solve(s1,s2, left, 0, dp);

            if(len < INF){
                if(minLen > len){
                    minLen = len;
                    ans = s1.substring(left, left + len);
                }
            }
        }
        return ans;
    }
}