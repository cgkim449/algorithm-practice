package codeforces;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * Created by cgkim449
 * Date: 2021-12-05
 * Time: 11:05
 * https://codeforces.com/problemset/problem/158/A
 */
public class A158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");

        int count = 0;

        for (int i = 1; i < k; i++) {
            int a = Integer.parseInt(st.nextToken());
            if(a > 0) {
                count++;
            }
        }

        int z = Integer.parseInt(st.nextToken());
        if(z > 0) {
            count++;
        }

        for (int i = k + 1; i <= n; i++) {
            int a = Integer.parseInt(st.nextToken());
            if(a >= z && a > 0) {
                count++;
            }
        }

        bw.write(String.valueOf(count));
        bw.close();
        br.close();
    }
}
