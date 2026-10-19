class Solution {

            public int solve(int[][] costs, int idx, int prevColor,Map<String, Integer> map){

        if(idx >= costs.length) return 0;

        String key = Integer.toString(idx) + "#" + Integer.toString(prevColor);
        if(map.containsKey(key)) return map.get(key);

        int[] cost = costs[idx];

        int best = Integer.MAX_VALUE;
        for(int i=0;i<cost.length;i++){
            if(i == prevColor) continue; // can not pick this house , as two adjust house can not have same color 
            best = Math.min(best, cost[i] + solve(costs, idx+1, i, map));

        }
        map.put(key, best);
        return best;


    }


    public int minCost(int[][] costs) {
         Map<String, Integer> map = new HashMap<>();
        return solve(costs,0, -1, map);

    }
}