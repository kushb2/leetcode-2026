class Solution {
    public void reverse(char[] arr, int left, int right){
        while(left < right){
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++; right--;
        }
    }

    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
         int idx = 0, n = arr.length;
         while(idx < n){

            // any leading space or in between space 
            while(idx<n && arr[idx] == ' '){
                idx++;
            }

            // find first space
            int left = idx; 
            while(idx<n && arr[idx] != ' '){ // Mr Ding
                idx++;
            }

            reverse(arr, left, idx-1);

        }
        
        return new String(arr);
    }
}