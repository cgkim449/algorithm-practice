package codeforces;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Date: 2021-12-14
 * Time: 11:50
 */
public class A791 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int years = 0;

        do {
            a *= 3;
            b *= 2;
            years++;
        } while (a <= b);

        System.out.println(years);
        sc.close();
    }
}
