package baekjoon.bruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * Date: 2021-12-20
 * Time: 14:41
 * https://www.acmicpc.net/problem/15649
 */
public class 유형2_중복없이_순서있게나열하기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;
    static int[] selected;
    static int[] used;

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        selected = new int[M+1];
        used = new int[N+1];
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
                sb.append(i1).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int cand = 1; cand <= N; cand++) {
            if(used[cand] == 1) continue;
            selected[k] = cand;
            used[cand] = 1;
            recFunc(k+1);
            selected[k] = 0;
            used[cand] = 0;
        }
    }

    private static void output() throws IOException {
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
