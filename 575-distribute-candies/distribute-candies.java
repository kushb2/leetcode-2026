class Solution {
    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();
        int count = candyType.length;
        for(int it: candyType) set.add(it);

        return Math.min(set.size(), count/2);
        
    }
}