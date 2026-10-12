class Solution {
    public int solve(char[] arr1, int i, char[] arr2, int j,int[][] dp){
        if(i < 0 || j < 0){
            return 0;
        }
        if(dp[i][j] != -1) return dp[i][j];

        if(arr1[i] == arr2[j]){
            return dp[i][j] = 1 + solve(arr1, i-1, arr2, j-1, dp);
        }else {
            int pickFirst = solve(arr1, i, arr2, j-1, dp);
            int pickSecond = solve(arr1, i-1, arr2, j,dp);
            return dp[i][j] = Math.max(pickFirst, pickSecond);
        }

    }

    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length(), m = text2.length();
        int[][] dp = new int[n+1][m+1];
        // text1 has one element only second case text2 has one element only as base case 
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else {
                    int pickFirst = dp[i][j-1]; 
                    int pickSecond = dp[i-1][j]; 
                    dp[i][j] = Math.max(pickFirst, pickSecond);
                }
            }
        }
        return dp[n][m];
    }
}

