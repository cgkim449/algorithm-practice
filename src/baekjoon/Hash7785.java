package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Created by cgkim449
 * Date: 2021-12-01
 * Time: 21:14
 * https://www.acmicpc.net/problem/7785
 */
public class Hash7785 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        Map<String, String> map = new HashMap<>();

        while(n-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            map.put(st.nextToken(), st.nextToken());
        }

        PriorityQueue<String> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        for (String s : map.keySet()) {
            if(map.get(s).equals("enter")) {
                priorityQueue.offer(s);
            }
        }
        while(!priorityQueue.isEmpty()) {
            sb.append(priorityQueue.poll()).append("\n");
        }
        bw.write(sb.toString());
        bw.close();
    }
}
