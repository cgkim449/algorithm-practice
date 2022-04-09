package programmers.practice;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Heap2 {
    public static void main(String[] args) {

    }
    public static int solution(int[][] jobs) {
        int answer = 0;

        PriorityQueue<Job> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.playtime));


        return answer;
    }

    static class Job {
        int starttime;
        int endtime;
        int playtime;

        public Job(int starttime, int endtime, int playtime) {
            this.starttime = starttime;
            this.endtime = endtime;
            this.playtime = playtime;
        }
    }
}

