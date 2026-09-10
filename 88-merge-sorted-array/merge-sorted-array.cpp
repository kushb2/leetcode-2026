class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        int i = m-1; // nums1 last index 
        int j = n-1; // nums 2 last index
        int k = nums1.size()-1;

        

        while(j >= 0 || i >= 0){ // 5 6 7 0 0 0 , 1,2 3
        int numA = i >= 0 ? nums1[i] : INT_MIN;
        int numB = j >= 0 ? nums2[j] : INT_MIN;

        if(numA >= numB) {
            nums1[k] = nums1[i];
            i--;
        }else{
            nums1[k] = nums2[j];
            j--;
        }
        k--;
        }
        
        
    }
};