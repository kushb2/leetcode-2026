class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair<String,Integer>> q = new ArrayDeque<>();
        Set<String> set = new HashSet<>(wordList);

        q.offer(new Pair(beginWord,1));
        while(!q.isEmpty()){
            int n = q.size();

            for(int i=0;i<n;i++){
                Pair<String,Integer> it = q.poll();
                int count = it.getValue();
                String currWord = it.getKey();

                if(currWord.equals(endWord)) return count;
                char[] currWordArr = currWord.toCharArray();
                for(int k=0;k<currWord.length();k++){
                    char curChar = currWordArr[k];
                    for(char z = 'a'; z<='z';z++){
                        currWordArr[k] = z;
                        String s = new String(currWordArr);
                        if(set.contains(s)){
                            set.remove(s);
                            q.offer(new Pair(s,count+1));
                        }
                    }
                    currWordArr[k] = curChar;
                }

            }
        }

        return 0;

        
    }
}