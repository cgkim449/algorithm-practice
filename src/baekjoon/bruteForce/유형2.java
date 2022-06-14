package baekjoon.bruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/15649
 */

public class 유형2 {
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
    private static int[] used;
    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        selected = new int[M + 1];
        used = new int[N + 1];
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
            for (int candidate = 1; candidate <= N; candidate++) {
                if(used[candidate] == 1) {
                    continue;
                }
                selected[k] = candidate;
                used[candidate] = 1;
                recurrenceFunction(k + 1);
                used[candidate] = 0;
                selected[k] = 0;
            }
        }
    }

    private static void output() throws IOException {
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
