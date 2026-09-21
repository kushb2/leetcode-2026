class Solution {
public:
    bool same(vector<int> &source, vector<int> &target){
        for(int i=0;i<source.size();i++){
            if(source[i] != target[i]) return false;
        }
        return true;
    }

    vector<int> merge(vector<int> &newTriplet,vector<int> &currTriplet, vector<int> &target){
        vector<int> mergedTriple(3);
        for(int i=0;i<newTriplet.size();i++){
            mergedTriple[i] = max(currTriplet[i], newTriplet[i]);
            if(mergedTriple[i] > target[i]){
                cout<<mergedTriple[i]<<" "<<target[i]<<endl;
                return currTriplet;
            } 
        }
        return mergedTriple;

    }
    bool mergeTriplets(vector<vector<int>>& triplets, vector<int>& target) {
        int index = 0;
        vector<int> currTriples(3,0);
    

        while(index < triplets.size()){

            currTriples = merge(triplets[index], currTriples, target);
            for(auto it: currTriples){
                cout<<it<<" ";
            }
            cout<<endl;
            if(same(currTriples, target)){
                return true;
            }
            index++;

        }
        return false;
        
    }
};