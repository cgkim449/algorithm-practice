package codeforces;

import java.util.Scanner;

/**
 * Date: 2021-12-11
 * Time: 16:00
 */
public class Cofo281A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] charArray = sc.nextLine().toCharArray();

        char c = charArray[0];

        if(c >= 97) {
            charArray[0] -= 32;
        }

        System.out.println(charArray);

        sc.close();
    }
}
