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
 * Time: 20:48
 */
public class B001_탑다운_카드구매하기2 {
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
        sb.append(f(n));

        output();
    }
    private static int f(int n) {
        if (memo[n] == 0) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i = 1; i <= n / 2; i++) {
                if (memo[i] == 0) {
                    memo[i] = f(i);
                }
                if (memo[n - i] == 0) {
                    memo[n - i] = f(n - i);
                }
                arrayList.add(f(i) + f(n - i));
            }
            arrayList.add(p[n]);
            Collections.sort(arrayList);
            memo[n] = arrayList.get(0);
        }
        return memo[n];
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
