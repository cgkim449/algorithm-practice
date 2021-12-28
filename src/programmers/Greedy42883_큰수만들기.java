package programmers;
/**
 * Date: 2021-12-28
 * Time: 10:31
 * https://programmers.co.kr/learn/courses/30/lessons/42883
 */
public class Greedy42883_큰수만들기 {
    public static void main(String[] args){
        System.out.println(solution("21", 1)); // 7752841  4
    }
    public static String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();

        while (true) {
            int index;

            for (int i = 9; i >= 1; i--) {
                index = number.indexOf(String.valueOf(i));

                if(-1 < index && index <= k) {
                    if(index == 0) {
                        if(number.length() == 1) {
                            number = "";
                            k -= 1;
                            break;
                        }
                        break;
                    }
                    number = number.substring(index);
                    k -= index;
                    break;
                }
            }

            if(k==0) {
                sb.append(number);
                break;
            }

            sb.append(number.charAt(0));
            number = number.substring(1);
        }
        return sb.toString();
    }
}
