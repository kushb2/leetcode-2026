class Solution {
public:
    int canCompleteCircuit(vector<int>& gas, vector<int>& cost) {

        int n = gas.size();

        for (int start = 0; start < n; start++) {

            long long currGas = 0;
            int visited = 0;
            int index = start;

            while (visited < n) {

                currGas += gas[index];

                // cannot go from this station to next
                if (currGas < cost[index]) {
                    break;
                }

                currGas -= cost[index];

                index = (index + 1) % n;
                visited++;
            }

            // completed all stations
            if (visited == n) {
                return start;
            }
             // We failed at `index`.
            // No need to try any station from start+1 ... index.
            // Jump directly to the next station.
            if (index < start) {
                // wrapped around and still failed,
                // so no later untried start can work
                return -1;
            }

            start = index;
        }

        return -1;
        
    }
};