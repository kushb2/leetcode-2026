class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        // if odd then middle other wise (middle-1 + middle)/2
        int n = nums1.size(), m = nums2.size();
        bool odd = (n + m) % 2 == 0 ? false : true;
        int middle = (n+m)/2;
        int i = 0, j = 0, k = 0;
        double prev = 0, curr = 0;
        while(k <= middle){
            int a = i < n ? nums1[i] : INT_MAX;
            int b = j < m ? nums2[j] : INT_MAX;
            prev = curr;
            if(a < b){
                curr = a;
                i++;
            }else{
                curr = b;
                j++;
            }
            k++;
        }

        return odd ? curr : (prev + curr)/2;

        
    }
};