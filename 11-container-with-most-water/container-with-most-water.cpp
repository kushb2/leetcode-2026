class Solution {
public:
    int maxArea(vector<int>& height) {
        int left = 0, right = height.size()-1;
        int maxArea = 0;

        while(left < right){
            int currArea = min(height[left] , height[right]) * (right - left );
            maxArea = max(currArea,maxArea);

            // we want to maximise the currArea , so next we want to choose more heingh 
            // as widht is descresing , if we chose min heigh 

            if(height[left] > height[right]){
                right--;
            }else{
                left++;
            }

        }
        return maxArea;
        
    }
};