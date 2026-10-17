class Solution {
    public String alienOrder(String[] words) {
        int n = words.length;
        Map<Character, Integer> map = new HashMap<>(); // inDegree for each key 
        Map<Character, List<Character>> adj = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for(String it: words){
            for(char c : it.toCharArray())
                set.add(c);
        }

        for(char it: set){
            map.put(it, 0);
            adj.put(it, new ArrayList<>());
        }


        for(int k=0;k<n-1;k++){

            String one = words[k];
            String two = words[k+1];

            int i = 0, j = 0;

            while(i< one.length() && j < two.length()){
                char a = one.charAt(i);
                char b = two.charAt(j);

                if( a != b){
                    adj.get(a).add(b);
                    map.put(b, map.get(b)+1);
                    break;
                }
                i++; j++;
            }

            if(j == two.length() && i == one.length()-1) {
                return "";
            }
        }

        Queue<Character> q = new ArrayDeque<>();
        for(var it: map.entrySet()){
            if(it.getValue() == 0){
                q.add(it.getKey());
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            char a = q.poll();
            sb.append(a);

            for(char it : adj.get(a)){

                map.put(it, map.get(it) - 1);

                if(map.get(it) == 0){
                    q.offer(it);
                }

            }

        }

        return sb.length() == set.size() ? new String(sb) : "";


        
    }
}