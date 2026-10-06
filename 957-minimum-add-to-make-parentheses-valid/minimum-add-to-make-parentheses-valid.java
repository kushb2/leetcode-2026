class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        int count = 0;// invalid

        for(char c: s.toCharArray()){
            if(c == '('){
                st.add(c);
            }else if(!st.isEmpty()){
                st.pop();
            }else{
                count++;
            }
        }

        return count + st.size();
        
    }
}