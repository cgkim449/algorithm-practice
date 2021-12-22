package programmers;

import java.io.IOException;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Date: 2021-12-21
 * Time: 10:51
 * https://programmers.co.kr/learn/courses/30/lessons/42840
 */
public class BruteForce42840_모의고사 {
    public static void main(String[] args) throws IOException {
        int[] answers1 = {1, 2, 3, 4, 5};
        int[] answers2 = {1, 3, 2, 4, 2};
        System.out.println(Arrays.toString(solution(answers2)));
    }
    
    // 5,8,10
    public static Integer[] solution(int[] answers) {
        int[] supoza1 = {1, 2, 3, 4, 5};
        int[] supoza2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] supoza3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;

        for (int i = 0; i < answers.length; i++) {
            int i1 = answers[i];
            if(i1 == supoza1[i%5]) {
                sum1++;
            }
            if(i1 == supoza2[i%8]) {
                sum2++;
            }
            if(i1 == supoza3[i%10]) {
                sum3++;
            }
        }
        System.out.println(sum1);
        System.out.println(sum2);
        System.out.println(sum3);

        int max = Math.max(Math.max(sum1, sum2), sum3);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        if(max == sum1) {
            pq.offer(1);
        }
        if(max == sum2) {
            pq.offer(2);
        }
        if(max ==sum3) {
            pq.offer(3);
        }

        Integer[] temp = new Integer[0];
        return pq.toArray(temp);
    }
}
