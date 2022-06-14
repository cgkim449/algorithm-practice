package baekjoon.bruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/15650
 */

public class 유형4 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        input();
        service();
        output();
    }

    private static int N, M;
    private static int[] selected;

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        selected = new int[M + 1];
    }

    private static void service() {
        recurrenceFunction(1);
    }

    private static void recurrenceFunction(int k) {
        if(k == M + 1) {
            for (int i = 1; i <= M; i++) {
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
        } else {
            int start = selected[k - 1] + 1;
            for (int candidate = start; candidate <= N; candidate++) {
                selected[k] = candidate;
                recurrenceFunction(k + 1);
            }
        }
    }

    private static void output() throws IOException {
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
