class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for(String it: wordList) set.add(it);

        if(!set.contains(endWord)) return 0;

        Deque<String> q = new ArrayDeque<>();

        q.offer(beginWord);
        set.remove(beginWord);
        int count = 0;
        while(!q.isEmpty()){
            count++;
            int n = q.size();
            for(int k=0;k< n;k++) {
                

            String currS = q.poll();
            if(currS.equals(endWord)) {
                return count;
            }
            

            char[] chars = currS.toCharArray();

            for(int i=0;i<chars.length;i++){
                char originalChar = chars[i];

                for(char j = 'a'; j<= 'z';j++){

                    chars[i] = j;

                    String newString = new String(chars);
                    if(set.contains(newString)){
                        q.offer(newString);
                        set.remove(newString);
                    }
                }
                chars[i] = originalChar;

            }
        }
    }

        return 0;
        
    }
}