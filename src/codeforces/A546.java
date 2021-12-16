package codeforces;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Date: 2021-12-15
 * Time: 18:56
 */
public class A546 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        System.out.println(Math.max(k * w * (w + 1) / 2- n, 0));
        sc.close();
    }
}
