class Solution {
public:
    int mostBooked(int n, vector<vector<int>>& meetings) {
    //    sort meeting
    sort(meetings.begin(), meetings.end());
    set<int> set;
    for(int i=0;i<n;i++){
        set.insert(i);
    }
    map<int,int> roomFreq;

    priority_queue<pair<long,int>, vector<pair<long,int>>, greater<pair<long,int>>> pq; // min head 

    for(auto it: meetings){

        // remove all ended meeting 
        while(!pq.empty() && pq.top().first <= it[0]){
            pair<int, int> meeting = pq.top();
            pq.pop();
            set.insert(meeting.second);// room no
        }

        // pick the first available meeting room 
        if(set.empty()){ // if no room free pick the first used room and make it free 
                pair<long, int> meeting = pq.top();
                pq.pop();
                pq.push({ meeting.first + (it[1] - it[0]), meeting.second});
                roomFreq[meeting.second]++;
        }else{
                int freeRoom = *set.begin();
                set.erase(freeRoom);
                pq.push({it[1], freeRoom});
                roomFreq[freeRoom]++;
        }
    }

    int maximumFeq = 0, lowestIndex = 0;
    for(auto [key, freq] :  roomFreq){
        if(freq > maximumFeq){
            maximumFeq = freq;
            lowestIndex = key;
        }
    }

    return lowestIndex;



    }


};