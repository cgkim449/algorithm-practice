package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by cgkim449
 * Date: 2021-12-03
 * Time: 21:00
 * https://codeforces.com/problemset/problem/4/A
 */
public class A4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        System.out.println(n % 2 == 0 && n > 2? "YES" : "NO");

        br.close();
    }
}
