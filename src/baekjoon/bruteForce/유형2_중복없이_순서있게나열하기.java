package baekjoon.bruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
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

    static HashMap<Integer, Boolean> jumpMap = new HashMap<>();

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
                sb.append(i1).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int cand = 1; cand <= N; cand++) {
            if(jumpMap.containsKey(cand) && jumpMap.get(cand)) {
                continue;
            }
            selected[k] = cand;
            jumpMap.put(cand, true);
            recFunc(k+1);
            selected[k] = 0;
            jumpMap.put(cand, false);
        }
    }

    private static void output() throws IOException {
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
/*
 * > 유형1에서 코드를 좀만 바꾸면됨
 */

/*
 * 시간복잡도: O(nPm) -> O(n!)(최악의 경우)
 * 공간복잡도: O(M)
 */