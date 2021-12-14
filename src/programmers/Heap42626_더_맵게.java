package programmers;

import java.util.PriorityQueue;

/**
 * Date: 2021-12-12
 * Time: 20:03
 * https://programmers.co.kr/learn/courses/30/lessons/42626
 */
public class Heap42626_더_맵게 {
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
 * 테스트 1 〉	통과 (136.92ms, 65.6MB)
 * 테스트 2 〉	통과 (321.94ms, 105MB)
 * 테스트 3 〉	통과 (1723.71ms, 122MB)
 * 테스트 4 〉	통과 (110.23ms, 65.6MB)
 * 테스트 5 〉	통과 (1713.51ms, 126MB)
 */

/*
 * 최소값 구하는 문제. 근데 이게 왜 최소값이 되는지는 모르겠음.
 */