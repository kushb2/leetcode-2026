class Solution {
    public String multiply(String num1, String num2) {
        char[] s1 = new StringBuilder(num1).reverse().toString().toCharArray();
        char[] s2 = new StringBuilder(num2).reverse().toString().toCharArray();

        int n = s1.length, m = s2.length;
        int[] res = new int[n + m];

// Step 2: Multiply and accumulate directly at (i + j)
        for (int i = 0; i < n; i++) {
            int first = s1[i] - '0';
            int startIndex = i;
            for (int j = 0; j < m; j++) {
                int second = s2[j] - '0';
                res[startIndex++] += first * second;  
            }
        }

// Step 3: Single carry pass from left to right
        for(int i=0;i<res.length-1;i++){
            res[i+1] += res[i]/10;
            res[i] = res[i] % 10;
        }

        // Step 4: Build result backwards (skipping any trailing zero at the very end)
        int end = res.length - 1;
        while (end > 0 && res[end] == 0) {
            end--;
        }

        StringBuilder ans = new StringBuilder();
        for (int i = end; i >= 0; i--) {
            ans.append(res[i]);
        }

        return ans.toString();


        
    }
}