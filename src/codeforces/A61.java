package codeforces;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * Date: 2022-01-03
 * Time: 23:00
 */
public class A61 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        String a = br.readLine();
        String b = br.readLine();

        for (int i = 0; i < a.length(); i++) {
            if(a.charAt(i)==b.charAt(i)){
                sb.append('0');
            } else {
                sb.append('1');
            }
        }

        output();
    }

    private static void output() throws IOException {
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
