package codeforces;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * Date: 2021-12-21
 * Time: 19:25
 */
public class A110 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    private static String S;
    private static int count;

    private static void input() throws IOException {
        S = br.readLine();
    }

    public static void main(String[] args) throws IOException {
        input();
        solution();
        output();
    }

    private static void solution() {
        for (int i = 0; i < S.length(); i++) {
            if(S.charAt(i) == '7' || S.charAt(i) == '4') {
                count++;
                if(count > 7) {
                    sb.append("NO");
                    return;
                }
            }
        }
        if(count == 7 || count == 4) {
            sb.append("YES");
            return;
        }
        sb.append("NO");
    }

    private static void output() throws IOException {
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
