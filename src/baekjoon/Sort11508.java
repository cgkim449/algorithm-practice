package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * Created by cgkim449
 * Date: 2021-12-03
 * Time: 09:44
 * https://www.acmicpc.net/problem/11508
 */
public class Sort11508 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);

        while(n-- > 0) pq.offer(Integer.parseInt(br.readLine()));

        int answer = 0;

        int i = 0;
        while(!pq.isEmpty()) {
            int add = pq.poll();
            if(++i % 3 == 0) continue;
            answer += add;
        }

        System.out.println(answer);
        br.close();
    }
}
