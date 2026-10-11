class Solution {
    public boolean canPlance(int[] position, int m, int distance){
        int i = 0, n = position.length;
        while(i < n && m>1){
            int start = position[i];
            while(i<n && (position[i] - start < distance)){
                i++;
            }           
            if(i != n){
                m--;
            }
        }

        return m == 1;
    }
    public int maxDistance(int[] position, int m) {
        int n = position.length;
        Arrays.sort(position);
        int left = 1;
        int right = position[n-1] - position[0];
        int ans = 0;
        while(left <= right){
            int mid = left + (right-left)/2; // can we place balls such a way that each boll differece is <= mid 
            if(canPlance(position , m , mid)){
                System.out.println(mid);
                ans = mid;
                left = mid+1;
            }else {
                right = mid-1;
            }
        }

        return ans;
        
    }
}