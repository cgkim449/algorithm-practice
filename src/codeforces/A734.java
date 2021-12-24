package codeforces;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * Date: 2021-12-23
 * Time: 23:23
 */
public class A734 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        int a = 0;
        String s = br.readLine();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='A') {
                a++;
            }
        }
        sb.append(a > n-a ? "Anton":a == n-a ? "Friendship":"Danik");
        output();
    }

    private static void output() throws IOException {
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
