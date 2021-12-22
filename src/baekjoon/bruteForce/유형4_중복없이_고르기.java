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
 * https://www.acmicpc.net/problem/15650
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
        recFunc(1);
        output();
    }

    private static void recFunc(int k) {
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

/* ## 총정리
 * 완전 탐색 문제를 접근할 때는,
 * - 고를 수 있는 값의 종류 파악하기!!!!!!!!!
 * - 중복을 허용하는지, 순서가 중요한지 에따라 4유형으로 나뉨
 *
 * 시간복잡도는 차례대로
 * 1. O(n^m)
 * 2. O(nPm)
 * 3. O(n^m) 보단 작음
 * 4. O(nCm)
 *
 * 공간복잡도는 전부
 * O(m)
 * 
 * 4유형 모두 사람이 접근하는 방법으로 풀었고,
 * 모두 유형1의 코드에서 조금만 바꾸면 되는 코드들임
 * 
 * 인덱스 0~M이아닌 1~M+1로 했으니 주의..
 */