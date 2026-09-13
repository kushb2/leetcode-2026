class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];

        prefix[0] = suffix[n-1] = 0;

        for(int i=1;i<n;i++){
            prefix[i] = Math.max(prefix[i-1], height[i-1]);
        }
        for(int i=n-2;i>=0;i--){
            suffix[i] = Math.max(suffix[i+1], height[i+1]);
        }
        int ans = 0;
        for(int i=0;i<n;i++){
            int trappedWater = Math.min(prefix[i], suffix[i]) - height[i];
            if(trappedWater > 0) ans += trappedWater;
        }
        return ans;
    }
}