package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by cgkim449
 * Date: 2021-12-02
 * Time: 23:13
 */
public class B1213 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        char[] chars = br.readLine().toCharArray();

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int count = 0;

        for (int value : map.values()) {
            if(value % 2 == 1) {
                if(chars.length % 2 == 0) {
                    System.out.println("I'm Sorry Hansoo");
                    return;
                }
                count++;
            }

            if(count > 1) {
                System.out.println("I'm Sorry Hansoo");
                return;
            }
        }

        char last = 0;
        int lastN = 0;

        for (char c = 'A'; c <= 'Z'; c++) {
            if(map.get(c) == null) continue;
            if(map.get(c) % 2 == 1) {
                last = c;
            }

            int n = map.get(c) / 2;
            while(n-- > 0) {
                sb.append(c);
            }
        }

        String s1 = sb.toString();
        String s2 = sb.reverse().toString();
        if(last == 0) {
            System.out.println(s1 + s2);
        } else {
            System.out.println(s1 + last + s2);
        }

        br.close();
    }
}
