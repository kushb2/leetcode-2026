class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack();

        for(int it: asteroids){
            boolean alive = true;

            while(alive && it < 0 && !st.isEmpty() && st.peek() > 0) {
                // current asstoriad still alive and its negative and st.peek is positive 
                // that means colision will happen 
                int top = st.peek();
                int temp = it * -1;

                if(top < temp){
                    st.pop();
                }else if(top == temp){
                    st.pop();
                    alive = false;
                }else{
                    alive = false;
                }
            }

            if(alive){
                st.add(it);
            }

        }

        // Convert stack back to array in correct order (left to right)
        int[] result = new int[st.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = st.pop();
        }

        return result;
        
        
    }
}