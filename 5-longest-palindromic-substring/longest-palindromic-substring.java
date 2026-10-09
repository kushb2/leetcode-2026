class Solution {
    public String longestPalindrome(String s) {
        char[] arr = s.toCharArray();
        int n = s.length();
        int maxSize = 1;
        int leftIndex = 0, rightIndex = 0;

        for(int i=0;i<n;i++){
            int left = i-1, right = i+1;
            while(left >= 0 && right < n && arr[left] == arr[right]){
                left--; right++;
            }
            left++; right--;

            if(right-left+1 > maxSize){
                maxSize = right-left+1;
                leftIndex = left;
                rightIndex = right;
            }
        }

        for(int i=0;i<n;i++){
            int left = i, right = i+1;
            while(left >= 0 && right < n && arr[left] == arr[right]){
                left--; right++;
            }
            left++; right--;

            if(right-left+1 > maxSize){
                maxSize = right-left+1;
                leftIndex = left;
                rightIndex = right;
            }
        }

        return s.substring(leftIndex, rightIndex+1);
        
    }
}