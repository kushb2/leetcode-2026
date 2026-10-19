class Solution {
    public int solve(String s1, String s2, int i, int j,int[][] dp){
        if(j == s2.length()){ // i find the s2 and i check till ith index 
            return i; // ending index right 
        }
        if(i == s1.length()){ // s1 finish and still s2 subsequence is not completed 
            return -1;
        }
        if(dp[i][j] != -2) return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = solve(s1, s2, i+1, j+1,dp);
        }else{
            return dp[i][j] = solve(s1, s2, i+1, j,dp);
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

            int right = solve(s1,s2, left, 0, dp);

            if(right != -1){
                if(minLen > right - left + 1){
                    minLen = right - left + 1;
                    ans = s1.substring(left, right);
                }
            }
        }
        return ans;
    }
}