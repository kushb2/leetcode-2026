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
        int[][] dp = new int[n][m];
        for(int[] it: dp) Arrays.fill(it, -1);

        return solve(text1.toCharArray(), n-1, text2.toCharArray(), m-1, dp);
    }
}

