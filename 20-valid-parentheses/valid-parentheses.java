class Solution {
    public boolean isValid(String s) {
        // ()[]{}
        // every time a closing bracket comes 
        // stack top should be the same if not return false
        // if yes pop the element 
        // handle stack empty case
        // at end if stack empty return true false 
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Deque<Character> st = new ArrayDeque<>();

        for(char c: s.toCharArray()){
            if(map.containsKey(c)){// exit brac is there 

                char top = st.isEmpty() ? '*' : st.pop();
                
                if(top != map.get(c)) return false;

            }else{
                st.push(c);
            }
            
        }
        return st.isEmpty();

    }
}