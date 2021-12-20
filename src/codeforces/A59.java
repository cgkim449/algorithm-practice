package codeforces;

import java.util.Locale;
import java.util.Scanner;

/**
 * Date: 2021-12-18
 * Time: 21:48
 */
public class A59 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        int u = 0;
        int l = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)<='Z') {
                u++;
            } else {
                l++;
            }
        }
        if(u<=l) {
            System.out.println(s.toLowerCase());
        } else {
            System.out.println(s.toUpperCase());
        }
        sc.close();
    }
}
