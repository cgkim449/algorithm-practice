package cgkim449;

import java.util.HashMap;

/**
 * Date: 2021-12-07
 * Time: 20:19
 */
public class ContainsKeyVsGet {
    public static void main(String[] args) {
        HashMap<String, HashMap<String, Integer>> hashMap = new HashMap<>();
        if(hashMap.containsKey("a")) {

        }

        if(hashMap.get("a") != null) { // 더 빠름. 단 HashMap은 key, value에 null허용이니 주의.(참고: HashTable은 null 허용아님)

        }
    }
}
