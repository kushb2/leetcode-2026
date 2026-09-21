class Solution {
public:
    bool isNStraightHand(vector<int>& hand, int groupSize) {
       map<int,int> cardAndThereFreq;
       for(auto it: hand){
        cardAndThereFreq[it]++;
       }
       
       while(!cardAndThereFreq.empty()){
            auto [card, freq] = *cardAndThereFreq.begin();
            int currCard = card;
             int currGroupSize = 0;
            while(currGroupSize < groupSize){
                if(cardAndThereFreq.contains(currCard)){
                    currGroupSize++;
                    cardAndThereFreq[currCard]--;
                    if(cardAndThereFreq[currCard] == 0){
                        cardAndThereFreq.erase(currCard);
                    }
                    currCard++;
                }else{
                    break;
                }
            }
            if(currGroupSize != groupSize) return false;
        
        }
        return true;
            
       }
};