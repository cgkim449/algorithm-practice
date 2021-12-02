package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * Created by cgkim449
 * Date: 2021-12-01
 * Time: 19:30
 * https://www.acmicpc.net/problem/10546
 */
public class Hash10546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = n - 1;

        HashMap<String, Integer> hashMap = new HashMap<>();

        while(n-- > 0) {
            String name = br.readLine();
            if(hashMap.get(name) != null) {
                hashMap.put(name, hashMap.get(name) + 1);
            } else {
                hashMap.put(name, 1);
            }
        }

        while(m-- > 0) {
            String name = br.readLine();
            hashMap.put(name, hashMap.get(name) - 1);
        }

        for (String key : hashMap.keySet()) {
            if(hashMap.get(key) == 1) {
                System.out.println(key);
                return;
            }
        }

    }
}
