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
        System.out.println(solution("AAAAA"));// 3 > 1
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

            // 'A'가 아닌 요소 중 가장 가까운 요소를 구하자
            int nearestFrontIndex = cursor;
            int minFrontMove = 0;

            int nearestBackIndex = cursor;
            int minBackMove = 0;

            // 앞으로 검색
            loop:
            while (true) {
                for (int i = nearestFrontIndex; i <= charArr.length-1; i++) {
                    char c = charArr[i];
                    if(c!='A'){
                        minFrontMove =i- nearestFrontIndex;
                        nearestFrontIndex =i;
                        break loop;
                    }
                }
                for (int i = 0; i < nearestFrontIndex; i++) {
                    char c = charArr[i];
                    if(c!='A'){
                        minFrontMove =charArr.length-1- nearestFrontIndex +1+i;
                        nearestFrontIndex =i;
                        break loop;
                    }
                }
                // 없다? 전부 'A'다 끝.
                return count;
            }
            
            // 뒤로 검색
            loop:
            while (true) {
                for (int i = nearestBackIndex; i >=0; i--) {
                    char c = charArr[i];
                    if(c!='A'){
                        minBackMove = nearestBackIndex -i;
                        nearestBackIndex =i;
                        break loop;
                    }
                }
                for (int i = charArr.length-1; i >= nearestBackIndex; i--) {
                    char c = charArr[i];
                    if(c!='A'){
                        minBackMove = nearestBackIndex +1+charArr.length-1-i;
                        nearestBackIndex =i;
                        break loop;
                    }
                }

                // 없다? 전부 'A'다 끝.
                return count;
            }

            int minMove = minFrontMove;
            cursor = nearestFrontIndex;

            if(minFrontMove > minBackMove){
                minMove = minBackMove;
                cursor= nearestBackIndex;
            }

            count+= minMove; // 커서 이동
        }
    }
}
