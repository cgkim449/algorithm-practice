package programmers.devMatching2nd2021;

class P1 {
    public int solution(String[] drum) {
        int answer = 0;

        Character[][] squares = new Character[drum.length][drum.length];

        for (int i = 0; i < drum.length; i++) {
            for (int j = 0; j < drum.length; j++) {
                squares[i][j] = drum[i].charAt(j);
            }
        }

        loop:
        for (int i = 0; i < drum.length; i++) {
            int x = 0;
            int y = i;
            boolean flag = false;

            while(true) {
                if(x == drum.length) {
                    answer++;
                    continue loop;
                }
                if(squares[x][y] == '#') {
                    x++;
                    continue;
                }
                if(squares[x][y] == '>') {
                    y++;
                    continue;
                }
                if(squares[x][y] == '<') {
                    y--;
                    continue;
                }
                if(squares[x][y] == '*') {
                    if(!flag) {
                        flag = true;
                        x++;
                        continue;
                    }
                    continue loop;
                }
            }
        }

        return answer;
    }
}
