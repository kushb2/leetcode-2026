class Solution {
    public int fib(int n) {
        if( n < 2) return n;
        int first = 0;
        int second = 1;
        n = n-2;
        while(n-- >= 0){
            int temp = second;
            second = first + second;
            first = temp;
        }
        return second;
        
    }
}