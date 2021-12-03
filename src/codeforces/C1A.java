package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by cgkim449
 * Date: 2021-12-03
 * Time: 21:34
 * https://codeforces.com/problemset/problem/1/A
 */
public class C1A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        long a = Long.parseLong(st.nextToken());

        long x = n % a == 0 ? n / a : n / a + 1;
        long y = m % a == 0 ? m / a : m / a + 1;

        System.out.println(x * y);
        br.close();
    }
}
