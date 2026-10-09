class Solution {
    public int longestPalindrome(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()) map.put(c, map.getOrDefault(c, 0)+1);
        for(var it: map.entrySet()){
                ans += (it.getValue() / 2) * 2;
        }

        if(ans < n) ans +=1;

        

        return ans;


    }
}

/*
abccccdd
a -> 1
b -> 1
c -> 4
d -> 3

=> 2 + 4 + 1 => 7


*/