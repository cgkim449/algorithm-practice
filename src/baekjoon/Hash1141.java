package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by cgkim449
 * Date: 2021-12-02
 * Time: 23:55
 * https://www.acmicpc.net/problem/1141
 * https://programmers.co.kr/learn/courses/30/lessons/42576
 */
public class Hash1141 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();

        while(n-- > 0) {
            set.add(br.readLine());
        }

        Iterator<String> iterator = set.iterator();
        Set<String> set1 = new HashSet<>();

        while(iterator.hasNext()) {
            String s = iterator.next();
            for (int i = 1; i < s.length(); i++) {
                String temp = s.substring(0, i);
                if(set.contains(temp)) {
                    set1.add(temp);
                }
            }
        }

        set.removeAll(set1);

        System.out.println(set.size());

        br.close();
    }
}
