class Solution {
    public int fib(int n) {
        if(n < 2) return n;
        int idx = 2,first = 0, second = 1;
        while(idx++ <= n){ // 2 => 1 , 3 => 2, 4 => 3
            int temp = first+second;
            first = second;
            second = temp;
        }
        return second;
        
    }
}