class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Queue<String> q = new ArrayDeque<>();
        Set<String> set = new HashSet<>(wordList);

        q.offer(beginWord);
        int count = 0;
        while(!q.isEmpty()){
            count++;
            int n = q.size();

            for(int i=0;i<n;i++){
                String currWord = q.poll();

                if(currWord.equals(endWord)) return count;
                char[] currWordArr = currWord.toCharArray();
                for(int k=0;k<currWord.length();k++){
                    char curChar = currWordArr[k];

                    for(char z = 'a'; z<='z';z++){
                        currWordArr[k] = z;
                        String s = new String(currWordArr);
                        if(set.contains(s)){
                            set.remove(s);
                            q.offer(s);
                        }
                    }
                    currWordArr[k] = curChar;
                }

            }
        }

        return 0;

        
    }
}