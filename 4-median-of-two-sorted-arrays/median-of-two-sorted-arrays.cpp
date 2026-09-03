class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
       int n = nums1.size(), m = nums2.size();
       int totalElement = n + m;
       int medianIndex = totalElement/2;
       bool odd = true;
       if(totalElement%2 == 0){
            odd = false;
            medianIndex--;
       }

       int i=0, j=0, k = 0;
       double sum = 0;
       while(i < n || j < m){
        int x = i < n ? nums1[i] : INT_MAX;
        int y = j < m ? nums2[j] : INT_MAX;
        int chooseNum;
        if( x < y) {
            chooseNum = x;
            i++;
        }else{
            chooseNum = y;
            j++;
        }

        if(medianIndex == k){
            sum += chooseNum;
            if(odd) break;
        }else if(!odd && medianIndex+1 == k){
            sum += chooseNum;
            break;
        }
        k++;
       }

       return odd ? sum : sum/2;
        
    }
};