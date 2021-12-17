package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * Date: 2021-12-17
 * Time: 21:36
 * https://www.acmicpc.net/problem/1715
 */
public class B1715_카드정렬하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while (n-- > 0) {
            int x = Integer.parseInt(br.readLine());
            pq.offer(x);
        }
        int sum = 0;
        while(true) {
            if(pq.size() == 1) {
                break;
            }
            int a = pq.poll();
            int b = pq.poll();
            sum +=(a+b);
            pq.offer(a+b);
        }
        System.out.println(sum);
        br.close();
    }
}
/*
 * 프머 스코빌이랑 비슷한듯
 */