package baekjoon.bruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * Date: 2021-12-20
 * Time: 14:14
 * https://www.acmicpc.net/problem/15651
 */
public class 유형1_중복을허용해서_순서있게나열하기 {
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
        // 1 번부터 M 번까지 잘 채워줘라
        recFunc(1);

        output();
    }

    // k 번부터 M 번까지 잘 채워주는 함수
    private static void recFunc(int k) {
        if(k == M+1) {
            for (int i = 1; i <= M; i++) {
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int cand = 1; cand <= N; cand++) {
            selected[k] = cand;

            recFunc(k + 1);
            selected[k] = 0;
        }
    }

    private static void output() throws IOException {
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
