package programmers.practice;

import java.util.HashSet;

public class Hash_전화번호목록 {
    public static void main(String[] args) {

    }

    public boolean solution(String[] phone_book) {
        boolean answer = true;

        HashSet<String> hashSet = new HashSet<>();
        for (String s : phone_book) {
            hashSet.add(s);
        }

        loop:
        for (int i = 0; i < phone_book.length; i++) {
            String s = phone_book[i];
            for (int j = 0; j < s.length(); j++) {
                if(hashSet.contains(s.substring(0, j))) {
                    answer = false;
                    break loop;
                }
            }
        }

        return answer;
    }
}
