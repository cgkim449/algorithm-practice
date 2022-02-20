package baekjoon.bruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/15651
 *
 * - recFunc(int k)는 k번부터 M번까지 잘 채워주는 함수입니다.
 * - 고를 수 있는 값(cand)을 파악하는 것이 중요합니다.
 * - 4개 유형 모두 사람이 접근하는 방법으로 풉니다. 모두 유형1에서 조금만 바꾸면 됩니다.
 *
 * 시간복잡도는 차례대로
 * 1. O(n^m)
 * 2. O(nPm)
 * 3. O(n^m) 보단 작음
 * 4. O(nCm)
 *
 * 공간복잡도는 전부
 * O(m)
 */
public class 유형1 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;

    private static int N,M;
    private static int[] selected;

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
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
        if(k==M+1){
            for (int i = 1; i < selected.length; i++) {
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
        } else {
            for (int cand = 1; cand <= N; cand++) {
                selected[k] = cand;
                recFunc(k+1);
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
