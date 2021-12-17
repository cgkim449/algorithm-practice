package codeforces;

import java.util.Scanner;

/**
 * Date: 2021-12-17
 * Time: 16:36
 */
public class A977 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        while(k-->0) {
            if(n%10==0) {
                n /=10;
            } else {
                n-=1;
            }
        }
        System.out.println(n);
        sc.close();
    }
}
