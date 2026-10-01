class Solution {
    int dfs(int[][] dp, char[] s, char[] t, int n, int m, int i, int j){
        if(j == m){
            return  1; // i found complete t string one posibile path is there 
        }

        if(i == n){
            return  0; // nothing to found futhere to complete t;
        }

        if(dp[i][j] != -1) return dp[i][j];


        if(s[i] == t[j]){// for matching with t[i] i can consider s[i] or i can i will not consdider 
        // see in future i make another s[i] == t[j]
            return dp[i][j] = dfs(dp, s,t,n,m, i+1, j+1) + dfs(dp, s, t, n, m, i+1, j);
        }else{
            return dp[i][j] =  dfs(dp, s, t, n, m, i+1, j);
        }

    }


    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
                Arrays.fill(dp[i], -1);
        }
        return dfs(dp, s.toCharArray(),t.toCharArray(),n,m,0,0);
    }
}