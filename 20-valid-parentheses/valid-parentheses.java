class Solution {
    public boolean isValid(String s) {
        // every time a closing bracket come 
        // check stack top is opening bracket or not 
        
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack<Character> st = new Stack<>();
        for(char c: s.toCharArray()){
            if(map.containsKey(c)){
                Character stackTop = st.isEmpty() ? '*' : st.peek();
                if(stackTop != map.get(c)) return false;
                st.pop();
            }else{
                st.push(c);
            }
        }
        return st.isEmpty();
    }
}