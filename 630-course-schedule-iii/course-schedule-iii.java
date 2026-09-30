class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a,b) -> a[1] - b[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        int n = courses.length;
        int time = 0;
        int compCourse = 0;
        for(int i=0;i<n;i++){
            int duration = courses[i][0];
            int lastDay = courses[i][1];
            
            if(time + duration <= lastDay){//can i take this course
                compCourse++;
                time += duration;
                pq.offer(duration);
            }else if(!pq.isEmpty() && pq.peek() > duration){// i can take curr course as it needed less time 
                    time -= pq.peek();
                    time += duration;
                    pq.poll();
                    pq.offer(duration);
            }
        }

        return compCourse;
        
    }
}