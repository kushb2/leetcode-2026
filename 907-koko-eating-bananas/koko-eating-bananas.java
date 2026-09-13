class Solution {
    public long  cal(int[] piles, int speed){
         long hour = 0;
        for(int it: piles){
            if(it % speed == 0){
                hour += it/speed;
            }else {
                 hour += it/speed + 1; 
            }
        }
        return hour;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1; // koko eating 1 bana per hour 
        int right = 0;// maximum speed to finish in h hour 
        for(int it: piles){
            right = Math.max(it, right);
        }

        int speed = 0;
        while(left <= right){
            int randomSpeed = left + (right - left)/2;
             long hourNeeded = cal(piles,randomSpeed);

            if(hourNeeded <= h){
                speed = randomSpeed;
                right = randomSpeed-1;
            }else{
                left = randomSpeed+1;
            }
        }
        return speed;
    }
}