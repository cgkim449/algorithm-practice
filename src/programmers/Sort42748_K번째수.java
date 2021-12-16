package programmers;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Date: 2021-12-16
 * Time: 10:46
 * https://programmers.co.kr/learn/courses/30/lessons/42748
 */
public class Sort42748_K번째수 {
    public static void main(String[] args) {

        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        System.out.println(Arrays.toString(solution(array, commands)));
    }

    static public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int index = 0;
        for (int[] command : commands) {
            pq.clear();
            for (int i = command[0]; i <= command[1]; i++) {
                pq.offer(array[i - 1]);
            } // 2 3 5 6
            for (int i = 0; i < command[2]-1; i++) {
                pq.poll();
            }
            answer[index++] = pq.poll();
        }

        return answer;
    }
}
