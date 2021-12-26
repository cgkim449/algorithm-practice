package baekjoon.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * Date: 2021-12-23
 * Time: 19:42
 */
public class B001_바텀업_카드구매하기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[] p;
    static int[] memo;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        p = new int[n+1];
        memo = new int[n+1];
        for (int i = 1; i <= n; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }
        memo[1] = p[1];
        for (int i = 2; i <= n; i++) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int j = 1; j <= i/2; j++) {
                arrayList.add(memo[j] + memo[i-j]);
            }
            arrayList.add(p[i]);
            Collections.sort(arrayList);
            memo[i]=arrayList.get(arrayList.size()-1);
        }
        sb.append(memo[n]);
        output();
    }

    /*
     * f(1)
     * f(2) max(f(1) + f(1), p2)
     * f(3) max(f(1) + f(2), p3)
     * f(4) max(f(1) + f(3), f(2) + f(2), p4)
     * f(5) max(f(1) + f(4), f(2) + f(3), p5)
     * f(6) max(f(1) + f(5), f(2) + f(4), f(3) + f(3), p6)
     */

    private static void output() throws IOException {
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
