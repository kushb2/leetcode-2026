class Solution {
    public String reverseWords(String s) {
        s += " ";
        char arr[] = s.toCharArray();
        int n = arr.length;
        int i = 0;
        List<String> words = new ArrayList<>();
        while(i<n){
            while(i<n && arr[i] == ' ') i++; // all space removed 
            // i pointing to first char 
            StringBuilder sb = new StringBuilder();
            while(i<n && arr[i] != ' '){
                sb.append(arr[i]);
                i++;
            }
            if(sb.length() > 0)
                words.add(new String(sb));
        }
        StringBuilder sb = new StringBuilder();
        for(int k = words.size()-1;k>=0;k--){
            sb.append(words.get(k));
            
            if(k > 0){
                sb.append(" ");
            }
        }

        return new String(sb);





        
    }
}