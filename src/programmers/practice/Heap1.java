package programmers.practice;

import java.util.PriorityQueue;

public class Heap1 {
    public static void main(String[] args) {

    }

    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : scoville) {
            pq.offer(i);
        }
        while (true) {
            int a = pq.poll();
            if(a >= K) {
                break;
            }
            if(pq.isEmpty()) {
                answer = -1;
                break;
            }
            int b = pq.poll();
            int c = a + 2 * b;
            answer++;
            pq.offer(c);
        }

        return answer;
    }
}
