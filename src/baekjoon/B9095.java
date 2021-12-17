package baekjoon;

import java.util.Scanner;

/**
 * Date: 2021-12-16
 * Time: 17:57
 * https://www.acmicpc.net/problem/9095
 */
public class B9095 {
    public static int f(int n) {
        if(n==1) {
            return 1;
        }
        if(n==2) {
            return 2;
        }
        if(n==3) {
            return 4;
        }
        return f(n-1) + f(n-2)+f(n-3);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            int n = Integer.parseInt(sc.nextLine());
            System.out.println(f(n));
        }
        sc.close();
    }
}
