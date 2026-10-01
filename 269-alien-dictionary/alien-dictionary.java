class Solution {
    public String alienOrder(String[] words) {
        // create the adj list for each char to come into the disc , which char need to peocess first
        Map<Character, Set<Character>> adj = new HashMap<>(); 
        Map<Character, Integer> inDegree = new HashMap<>();
        
        for(String word : words){ // fill all inDegree with 0 In Degree
            char[] arr = word.toCharArray();
            for(int i=0;i<arr.length;i++){
                adj.putIfAbsent(arr[i], new HashSet<>());
                inDegree.putIfAbsent(arr[i], 0);
            }
        }

        for(int i=0;i< words.length-1;i++){
            String w1 = words[i];
            String w2 = words[i+1];

            if(w1.length() > w2.length() && w1.startsWith(w2)){
                return "";
            }

            int minLen = Math.min(w1.length(), w2.length());

            for(int j=0;j<minLen;j++){
                char from = w1.charAt(j);
                char to = w2.charAt(j);

                if(from != to){
                    if(!adj.get(from).contains(to)){
                        adj.get(from).add(to);
                        inDegree.put(to, inDegree.get(to)+1);
                    }
                    break;
                }
            }
        }

        Queue<Character> q = new ArrayDeque<>();
        for(var it : inDegree.entrySet()){ // process all key where in Degree is no depdency should come first 
            if(it.getValue() == 0){
                q.offer(it.getKey());
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            char c = q.poll();
            sb.append(c);

            for(char it: adj.get(c)){ // get all depdency and decrese there depdency 
                inDegree.put(it, inDegree.get(it) - 1);
                if(inDegree.get(it) == 0){ // which become indepdnet add them to the queue 
                    q.offer(it);
                }
            }
            
        }

        return sb.length() == inDegree.size() ? new String(sb) : "";

        
    }
}