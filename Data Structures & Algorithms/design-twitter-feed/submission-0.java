class Twitter {
    HashMap<Integer, HashSet<Integer>> followMap = new HashMap<>();
    HashMap<Integer, List<int[]>> tweetMap = new HashMap<>();
    int time = 0;

    public Twitter() {}
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.putIfAbsent(userId, new ArrayList<>());
        tweetMap.get(userId).add(new int[]{time, tweetId});
        time++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        List<Integer> result = new ArrayList<>();

        followMap.putIfAbsent(userId, new HashSet<>());
        followMap.get(userId).add(userId);

        for (int followeeId : followMap.get(userId)) {
            if (tweetMap.containsKey(followeeId)) {
                List<int[]> tweets = tweetMap.get(followeeId);
                int index = tweets.size() - 1;
                maxHeap.add(new int[]{tweets.get(index)[0], tweets.get(index)[1], followeeId, index});
            }
        }

        while (!maxHeap.isEmpty() && result.size() < 10) {
            int[] top = maxHeap.poll();
            result.add(top[1]);
            if (top[3] > 0) {
                List<int[]> tweets = tweetMap.get(top[2]);
                int index = top[3] - 1;
                maxHeap.add(new int[]{tweets.get(index)[0], tweets.get(index)[1], top[2], index});
            }
        }

        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).remove(followeeId);
    }
}