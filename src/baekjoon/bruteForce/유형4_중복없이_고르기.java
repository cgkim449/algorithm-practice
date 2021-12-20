package baekjoon.bruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * Date: 2021-12-20
 * Time: 17:43
 */
public class 유형4_중복없이_고르기 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;

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
        recurFunc(1);
        output();
    }

    private static void recurFunc(int k) {
        if(k == M+1) {
            for (int i = 1; i <= M; i++) {
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
            return;
        }
        int start = selected[k-1]+1;
        for (int i = start; i <= N; i++) {
            selected[k] = i;
            recurFunc(k+1);
            selected[k] = 0;
        }
    }

    private static void output() throws IOException {
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}

/*
 * 유형1에서 좀만 바꾸면된다
 */

/*
 * 시간복잡도: O(nCm)
 * 공간복잡도: O(M)
 */
