package codeforces;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Date: 2021-12-10
 * Time: 02:45
 */
public class C339A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        PriorityQueue<Character> pq = new PriorityQueue<>();
        for (int i = 0; i < s.length(); i+=2) {
            pq.offer(s.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            sb.append(pq.poll());
            if(pq.isEmpty()) {
                System.out.println(sb.toString());
                return;
            }
            sb.append("+");
        }

        sc.close();
    }
}
