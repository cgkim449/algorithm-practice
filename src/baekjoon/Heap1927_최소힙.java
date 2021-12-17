package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Date: 2021-12-17
 * Time: 23:16
 */
public class Heap1927_최소힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while (n-- > 0) {
            int x = Integer.parseInt(br.readLine());
            switch (x) {
                case 0:
                    if(pq.isEmpty()) {
                        sb.append(0).append("\n");
                    } else {
                        sb.append(pq.poll()).append("\n");
                    }
                    break;
                default:
                    pq.offer(x);
                    break;
            }
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
