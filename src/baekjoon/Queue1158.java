package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Date: 2021-12-09
 * Time: 09:59
 * https://www.acmicpc.net/problem/1158
 */
public class Queue1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        ArrayList<Integer> arrayList = new ArrayList<>(5000);
        for (int i = 1; i <= n; i++) {
            arrayList.add(i);
        }

        Queue<Integer> queue = new LinkedList<>(arrayList);
        sb.append("<");
        for (int i = 1; !queue.isEmpty(); i++) {
            int x = queue.poll();
            if(i % k == 0) {
                if (queue.isEmpty())  sb.append(x).append(">");
                else sb.append(x).append(", ");
            } else {
                queue.offer(x);
            }
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
