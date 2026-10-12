class Solution {
    public boolean solve(char[] arr, int n, int maxWordLen, Set<String> set, int[] visited, int idx){
        if(idx == n) return true;

        if(visited[idx] != -1){
            return visited[idx] == 1 ? true : false;
        }

        StringBuilder sb = new StringBuilder();
        for(int start = idx; start < Math.min(n, idx+maxWordLen); start++){
            sb.append(arr[start]);
            if(set.contains(sb.toString())){
               boolean ans = solve(arr, n, maxWordLen, set, visited, start+1);
               if(ans == true){
                    visited[start] = 1;
                    return true;
               }
            }
        }

        visited[idx] = 0;
        return false;

    }
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        int[] visited = new int[n];
        Arrays.fill(visited, -1);
        Set<String> set = new HashSet<>();
        int maxWordLen = 0;
        for(String it: wordDict){
            maxWordLen = Math.max(maxWordLen, it.length());
            set.add(it);
        } 

        return solve(s.toCharArray(), n, maxWordLen, set, visited, 0);

        



        
        
    }
}