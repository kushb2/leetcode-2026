class AuthenticationManager {
    Map<String,Integer> map;
    int timeToLive;

    public AuthenticationManager(int timeToLive) {
        map = new LinkedHashMap<>();
        this.timeToLive = timeToLive;
        
    }
    
    public void generate(String tokenId, int currentTime) {
        if(map.containsKey(tokenId)) map.remove(tokenId);
        map.put(tokenId, currentTime + timeToLive); 
    }
    
    public void renew(String tokenId, int currentTime) {
        if(!map.containsKey(tokenId)) return; //token does not exist
        if(map.get(tokenId) <= currentTime){
           map.remove(tokenId);
           return;
        }
        map.remove(tokenId);
        map.put(tokenId, currentTime + timeToLive); 
    }
    
    public int countUnexpiredTokens(int currentTime) {
        List<String> expiredTokenId = new ArrayList<>();
        for(var x : map.entrySet()){
            if(x.getValue() <= currentTime){
                expiredTokenId.add(x.getKey());
            }
        }

        for(String it: expiredTokenId){
             map.remove(it);
        }

        return map.size();
       
    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */