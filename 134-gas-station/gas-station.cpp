class Solution {
public:
    int canCompleteCircuit(vector<int>& gas, vector<int>& cost) {
        int n = gas.size();
        int start = 0;
        while(start < gas.size()){
           int i = start;
           int totalStationToCover = n;
           int totalGas = 0;
           while(totalStationToCover > 0){// 3 
            i = i % n;
            totalGas += gas[i];
            totalGas -= cost[i];

            // can move to next station 
            if(totalGas < 0){
                // can not go to next station 
                break;
            }
            totalStationToCover--;
            i++;
           }
           if(totalStationToCover == 0) return start;
           if(i < start) return -1;
           // if from i can not move further so i can not move from i-1 as well
           start = i+1;
        }
        return -1;
    }
};