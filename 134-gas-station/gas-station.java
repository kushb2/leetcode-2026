class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        for(int i=0;i<n;i++){// try starting journy from each station 
            int currGas = gas[i];
            int idx = i;  // starting index 
            int stationToVisit = n;
            while(stationToVisit>0 && currGas >= cost[idx]){ // we can move to next startion 
                currGas -= cost[idx];
                idx++;
                idx = idx % n;
                currGas += gas[idx];
                stationToVisit--;
            }

            if(idx < i) return -1;

            i = idx;

            if(stationToVisit == 0) {
                return i;
            }
        }
        return -1;
        
    }
}