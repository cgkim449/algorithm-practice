package codeforces;

import java.util.Scanner;

/**
 * Date: 2021-12-07
 * Time: 23:27
 * https://codeforces.com/problemset/problem/282/A
 */
public class A282 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int answer = 0;
        while(n-- > 0) {
            if(sc.nextLine().indexOf('+') != -1) {
              answer++;
            } else {
                answer--;
            }
        }
        System.out.println(answer);
        sc.close();
    }
}
