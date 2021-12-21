package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * Date: 2021-12-21
 * Time: 12:27
 * https://www.acmicpc.net/problem/10808
 */
public class B10808_알파벳_개수 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;


    static String s;
    private static void input() throws IOException {
        s = br.readLine();
    }

    public static void main(String[] args) throws IOException {
        input();
        solution();
        output();
    }

    private static void solution() {
        int[] counting = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counting[s.charAt(i) - 'a']++;
        }
        for (int a : counting) {
            sb.append(a).append(" ");
        }
    }

    private static void output() throws IOException {
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
