package baekjoon.bruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * Date: 2021-12-20
 * Time: 15:33
 * https://www.acmicpc.net/problem/15652
 */
public class 유형3_중복을허용해서_고르기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;
    static int[] selected;

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        selected = new int[M+1];
    }

    public static void main(String[] args) throws IOException {
        input();
        recFunc(1);
        output();
    }

    private static void recFunc(int k) {
        if(k == M+1) {
            for (int i = 1; i <= M; i++) {
                int i1 = selected[i];
                sb.append(i1).append(' ');
            }
            sb.append('\n');
            return;
        }
        int start = selected[k-1];
        if(start == 0) start = 1;
        for (int cand = start; cand <= N; cand++) {
            selected[k] = cand;
            recFunc(k+1);
            selected[k] = 0;

        }
    }

    private static void output() throws IOException {
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
