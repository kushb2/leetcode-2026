class Twitter {
    Map<Integer, Set<Integer>> idMap;
    Map<Integer, List<int[]>> tweets;
    int counter=0;

    public Twitter() {
        this.idMap = new HashMap<>();
        this.tweets = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId, new ArrayList<>());
        tweets.get(userId).add( new int[] {tweetId, counter++ });
    }
    
    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> allFollower = new HashSet<>();
        allFollower.add(userId);
        if(idMap.containsKey(userId)){
            allFollower.addAll(idMap.get(userId));
        }
        

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);// minHeap
        for(int it: allFollower){
            if(!tweets.containsKey(it)) continue; // if it user has no tweets 

            for(int[] tweet: tweets.get(it)){
                pq.offer(tweet);
                if(pq.size() > 10){
                    pq.poll();
                }
            }

            

        }
        List<Integer> ans = new ArrayList<>();

        while(!pq.isEmpty()){
            ans.addFirst(pq.poll()[0]);
        }

        return ans;
        
    }
    
    public void follow(int followerId, int followeeId) {
        idMap.putIfAbsent(followerId, new HashSet<>());
        idMap.get(followerId).add(followeeId);

    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!idMap.containsKey(followerId)) return;
        idMap.get(followerId).remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */