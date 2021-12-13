package codeforces;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Date: 2021-12-13
 * Time: 10:01
 */
public class Cofo236A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        HashSet<Character> hs = new HashSet<>();
        for (char c : s.toCharArray()) {
            hs.add(c);
        }
        System.out.println(hs.size() % 2 == 0 ? "CHAT WITH HER!" : "IGNORE HIM!");
        sc.close();
    }
}
