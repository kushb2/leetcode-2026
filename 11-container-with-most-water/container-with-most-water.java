class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length-1, ans = 0;

        while(left < right){
            ans = Math.max((right-left) * Math.min(height[left], height[right]), ans);

            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return ans;
        
    }
}