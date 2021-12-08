package codeforces;

import java.util.Scanner;

/**
 * Date: 2021-12-09
 * Time: 00:15
 */
public class C112A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(Integer.compare(sc.nextLine().toLowerCase().compareTo(sc.nextLine().toLowerCase()), 0));
        sc.close();
    }
}
