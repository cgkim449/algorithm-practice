package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Date: 2021-12-22
 * Time: 12:08
 * https://www.acmicpc.net/problem/10809
 */
public class B10809_알파벳_찾기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static String S;
    static int[] locations;

    private static void input() throws IOException {
        S = br.readLine();
        locations = new int['z'-'a'+1];
        Arrays.fill(locations, -1);
    }

    public static void main(String[] args) throws IOException {
        input();
        solution();
        output();
    }

    private static void solution() {
        for (int i = 0; i < S.length(); i++) {
            if(locations[S.charAt(i)-'a'] == -1) {
                locations[S.charAt(i)-'a'] = i;
            }
        }
    }

    private static void output() throws IOException {
        for (int i = 0; i < locations.length; i++) {
            int location = locations[i];
            sb.append(location).append(" ");
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
