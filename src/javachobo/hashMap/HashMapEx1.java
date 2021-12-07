package javachobo.hashMap;

import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

/**
 * Date: 2021-12-07
 * Time: 18:38
 */
public class HashMapEx1 {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put("myId", "1234");
        map.put("asdf", "1111");
        map.put("asdf", "1234");

        Scanner s = new Scanner(System.in);

        while (true) {
            System.out.println("id와 password를 입력해라");
            System.out.print("id:");
            String id = s.nextLine().trim();
            System.out.print("password :");
            String password = s.nextLine().trim();
            System.out.println();

            if(!map.containsKey(id)) {
                System.out.println("입력한 id는 없다");
                continue;
            }

            if(!(map.get(id)).equals(password)) {
                System.out.println("비밀번호가 틀렷다");
            } else {
                System.out.println("id와 비번이 일치한다");
                break;
            }
        }
    }
}
