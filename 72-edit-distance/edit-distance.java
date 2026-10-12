class Solution {

    int INF = (int)1e9;

    public int solve(char[] word1, int i, char[] word2, int j,int[][] dp){

        if(j < 0) {
            return i+1;
        }

        if(i < 0){
            return j+1;
        }

        if(dp[i][j] != -1) return dp[i][j];


        if(word1[i] == word2[j]){ // Match move to next index
            return solve(word1, i-1, word2, j-1,dp);
        }else{ // three options
            int cost = INF;
            int replace = solve(word1, i-1, word2, j-1,dp);
            int delete = solve(word1, i-1, word2, j,dp);
            int insert = solve(word1, i, word2, j-1,dp);
            cost = Math.min(cost, replace);
            cost = Math.min(cost, delete);
            cost = Math.min(cost, insert);
            return dp[i][j] = cost + 1;
        }
       
        
    }

    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n+1][m+1];
        

        for(int i=0;i<=n;i++){
            dp[i][0] = i;
        }

        for(int j=0;j<=m;j++){
            dp[0][j] = j;
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){ // Match move to next index
                    dp[i][j] = dp[i-1][j-1];
                }else{ // three options
                    int cost = INF;
                    int replace = dp[i-1][j-1];
                    int delete = dp[i-1][j];
                    int insert = dp[i][j-1];
                    cost = Math.min(cost, replace);
                    cost = Math.min(cost, delete);
                    cost = Math.min(cost, insert);
                    dp[i][j] = cost + 1;
                }
            }
        }

        return dp[n][m];


    }
}