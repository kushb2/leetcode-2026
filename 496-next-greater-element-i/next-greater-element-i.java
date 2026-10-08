class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums1.length;i++) map.put(nums1[i], i);
        int[] arr = new int[nums1.length];
        Arrays.fill(arr, -1);

        Stack<Integer> st = new Stack<>();

        for(int it: nums2){
            while (!st.isEmpty() && st.peek() < it) {
                int peek = st.peek();
                if(map.containsKey(peek)){
                    arr[map.get(peek)] = it;
                }
                st.pop();
            }
            st.add(it);
        }

        return arr;
        
    }
}