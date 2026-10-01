class Solution {
    int[][] dir = {
        {0,1}, {0,-1},{1,0},{-1,0}
    };

    boolean isValid( int i, int j, int n, int m, int[][] matrix,int previous){
        return i>=0 && j>=0 && i<n && j<m && matrix[i][j] > previous;
    }

    public int dfs(int[][] matrix,int[][] dp, int i, int j, int n, int m, int previous){
        // if not a valid index then we can not go further and rhis index also contibute 
        // longest inceeasing path start form i,j will be 0 
        if(!isValid(i, j, n, m, matrix, previous)) return 0;

        // if i already calculate longest path from i,j then simply return it 
        if(dp[i][j] != 0) return dp[i][j];
        
        int max = 0;
        for(int[] it: dir){
            int x = i + it[0];
            int y = j + it[1];
           max = Math.max(dfs(matrix, dp, x, y, n, m, matrix[i][j]), max);
        }
        dp[i][j] =  max + 1;
        return dp[i][j];

    }

    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[][] dp = new int[n][m]; // each index will store longest increaing path starting from [i][j];

        int ans = -1;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ans = Math.max(ans, dfs(matrix, dp , i, j, n, m, -1));
            }
        }
        return ans;
    }
}