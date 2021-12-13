package programmers;

import java.util.PriorityQueue;

/**
 * Date: 2021-12-12
 * Time: 20:03
 * https://programmers.co.kr/learn/courses/30/lessons/42626
 */
public class Heap42626 {
    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;
        System.out.println(solution(scoville, K));
    }

    static public int solution(int[] scoville, int K) {
        int count = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int sc : scoville) {
            pq.offer(sc);
        }

        while(!pq.isEmpty()) {
            int x = pq.poll();
            if(pq.isEmpty()) {
                if(x < K) { // 전부 섞어서 마지막에 남은 요리 하나
                    return -1;
                }
            }
            if(x >= K) {
                return count;
            }
            int y = pq.poll();
            pq.offer(x + 2 * y);
            count++;
            if(y >= K) {
                return count;
            }
        }
        return count;
    }
}
/*
 * 테스트 1 〉	통과 (194.10ms, 68.6MB)
 * 테스트 2 〉	통과 (249.46ms, 86.9MB)
 * 테스트 3 〉	통과 (1385.26ms, 124MB)
 * 테스트 4 〉	통과 (117.82ms, 65.2MB)
 * 테스트 5 〉	통과 (1566.65ms, 123MB)
 */

