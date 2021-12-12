package codeforces;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Created by cgkim449
 * Date: 2021-12-03
 * Time: 21:18
 * https://codeforces.com/problemset/problem/71/A
 */
public class Cofo71A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        while(n-- > 0) {
            String s = br.readLine();
            if(s.length() > 10) {
                sb.append(s.charAt(0)).append(s.length() - 2).append(s.charAt(s.length() - 1)).append("\n");
            } else {
                sb.append(s).append("\n");
            }
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
