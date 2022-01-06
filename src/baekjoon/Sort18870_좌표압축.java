package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Date: 2022-01-05
 * Time: 13:22
 */
public class Sort18870_좌표압축 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] result = new int[n];
        int count = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        for (int i = 0; i < n; i++) {
            int[] temp = new int[2];
            temp[0] = i;
            temp[1] = Integer.parseInt(st.nextToken());
            pq.offer(temp);
        }

        int previousValue = Integer.MAX_VALUE;
        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            int index = temp[0];
            int currentValue = temp[1];
            if(previousValue ==Integer.MAX_VALUE) {
                result[index] = 0;
                previousValue = currentValue;
            } else {
                if(previousValue == currentValue) {
                    result[index]=count;
                } else {
                    count++;
                    result[index]=count;
                    previousValue = currentValue;
                }
            }
        }
        for (int i : result) {
            sb.append(i).append(' ');
        }
        output();
    }

    private static void output() throws IOException {
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
