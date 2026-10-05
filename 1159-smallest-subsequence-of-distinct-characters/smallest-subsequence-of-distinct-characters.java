class Solution {
    public String reverse(char[] arr){
        int left = 0, right = arr.length-1;
        while(left < right){
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++; right--;
        }
        return new String(arr);
    }

    public String smallestSubsequence(String s) {
        Map<Character, Integer> lastOccurence = new HashMap<>();
        for(int i=0;i<s.length();i++) lastOccurence.put(s.charAt(i), i);

        Set<Character> includedChars = new HashSet<>();
        Stack<Character> st = new Stack<>();

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            // idea is if c is already part of the answer this current ans is oprimally right 
            // a char which we did not see solve it 
            while(!st.isEmpty() && st.peek() > c && !includedChars.contains(c) && lastOccurence.get(st.peek()) > i){
                // stack is not empty , peek has bigger element then i and it will come again in future 
                includedChars.remove(st.peek());
                st.pop();
            }

            if(!includedChars.contains(c)){
                includedChars.add(c);
                st.add(c);
            }

        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }

        return reverse(sb.toString().toCharArray());
        
    }
}