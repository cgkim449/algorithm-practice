package programmers;

/**
 * Date: 2021-12-28
 * Time: 12:11
 * https://programmers.co.kr/learn/courses/30/lessons/42860
 */
public class Greedy42860_조이스틱 {
    public static void main(String[] args) {
        System.out.println(solution("JEROEN")); // 012345
        System.out.println(solution("JAN"));
        System.out.println(solution("JAZ"));
        System.out.println(solution("BAABB"));// 1 11 11
    }
    public static int solution(String name) {
        int count = 0;
        int cursor = 0;

        char[] charArr = name.toCharArray();
        
        while (true) {
            if(charArr[cursor] <= 'N') {
                count += charArr[cursor] - 'A';
            } else {
                count += 'Z'-charArr[cursor]+1;
            }

            charArr[cursor]='A';

            // 'A'가 아닌 인덱스 중 가장 가까운 인덱스 검색
            int shortestFront = 0;
            int shortestBack = 0;
            int shortestFrontIndex = cursor;
            int shortestBackIndex = cursor;
    
            // 앞으로 검색
            loop:
            while (true) {
                for (int i = shortestFrontIndex; i <= charArr.length-1; i++) {
                    char c = charArr[i];
                    if(c!='A'){
                        shortestFront =i- shortestFrontIndex;
                        shortestFrontIndex =i;
                        break loop;
                    }
                }
                for (int i = 0; i < shortestFrontIndex; i++) {
                    char c = charArr[i];
                    if(c!='A'){
                        shortestFront =charArr.length-1- shortestFrontIndex +1+i;
                        shortestFrontIndex =i;
                        break loop;
                    }
                }
                // 없다? 전부 'A'다 끝.
                return count;
            }
            
            // 뒤로 검색
            loop:
            while (true) {
                for (int i = shortestBackIndex; i >=0; i--) {
                    char c = charArr[i];
                    if(c!='A'){
                        shortestBack = shortestBackIndex -i;
                        shortestBackIndex =i;
                        break loop;
                    }
                }
                for (int i = charArr.length-1; i >= shortestBackIndex; i--) {
                    char c = charArr[i];
                    if(c!='A'){
                        shortestBack = shortestBackIndex +1+charArr.length-1-i;
                        shortestBackIndex =i;
                        break loop;
                    }
                }

                // 없다? 전부 'A'다 끝.
                return count;
            }

            int shortest = shortestFront;
            cursor = shortestFrontIndex;

            if(shortestFront > shortestBack){
                shortest = shortestBack;
                cursor= shortestBackIndex;
            }

            count+=shortest; // 커서 이동
        }
    }
}
