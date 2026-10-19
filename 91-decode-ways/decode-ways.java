class Solution {
    public int solve(String s, int n,int[] dp){
        if(n <= 1) return 1;  // empty string or 1 char has exactly one way to decode 

        if(dp[n] != -1) return dp[n];

        int oneDigit = Integer.parseInt(s.substring(n-1, n));
        int twoDigit = Integer.parseInt(s.substring(n-2, n));
        dp[n] = 0;
        if(1 <= oneDigit && oneDigit <= 9){
            dp[n] += solve(s, n-1,dp);
        }

        if(9 < twoDigit && twoDigit <= 26){
            dp[n] += solve(s, n-2,dp);
        }

        return dp[n];
    }
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n+1]; // no of ways to reach index i 
        Arrays.fill(dp, -1); // -1 represents sub problem is not calculated 
        if(s.charAt(0) == '0') return 0; // invalid case 
        return solve(s, n,dp);
        
    }
}