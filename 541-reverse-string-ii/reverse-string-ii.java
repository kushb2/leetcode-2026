class Solution {
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        int i=0;
        while(i< arr.length){
            int l = i, r = Math.min(arr.length-1, i+k-1);
            while(l < r){
                char temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
                l++; r--;
            }

            i = i+2*k;
        }
        return new String(arr);
        
    }
}