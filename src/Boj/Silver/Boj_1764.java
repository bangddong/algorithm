package Boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Boj_1764 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;
    static TreeMap<String, Integer> tm = new TreeMap<>();
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N + M; i++) {
            String tmp = br.readLine();
            tm.put(tmp, tm.getOrDefault(tmp, 0) + 1);
        }

        int answer = 0;
        for (String s : tm.keySet()) {
            if (tm.get(s) >= 2) {
                answer++;
                sb.append(s).append("\n");
            }
        }
        System.out.println(answer + "\n" + sb.toString());
    }
}
