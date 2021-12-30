package Boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_9095 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[] dy;
    public static void main(String[] args) throws IOException {
        dy = new int[12];
        solution();
        int T = Integer.parseInt(br.readLine());
        while (T --> 0) {
            int N = Integer.parseInt(br.readLine());
            sb.append(dy[N]).append('\n');
        }
        System.out.println(sb.toString());
    }

    static void solution() {
        dy[1] = 1; // 1 + 1
        dy[2] = 2; // 1 + 1, 2
        dy[3] = 4; // 1 + 1 + 1, 1 + 2, 2 + 1, 3
        for (int i = 4; i <= 11; i++) dy[i] = dy[i - 1] + dy[i - 2] + dy[i - 3];
    }
}
