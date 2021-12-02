import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, String> map = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            String name = br.readLine();
            map.put(String.valueOf(i), name);
            map.put(name, String.valueOf(i));
        }

        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            sb.append(map.get(s)).append("\n");
        }

        bw.write(sb.toString());
        bw.close();
    }
}
