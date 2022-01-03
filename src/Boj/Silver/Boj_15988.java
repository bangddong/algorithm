package Boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_15988 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static long[] dy;
    static int MOD = 1000000009;
    public static void main(String[] args) throws IOException {
        dy = new long[1000001];
        solution();

        int T = Integer.parseInt(br.readLine());
        while(T --> 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dy[n]).append('\n');
        }
        System.out.println(sb.toString());
    }

    static void solution() {
        dy[0] = 1;
        dy[1] = 1;
        dy[2] = 2;
        dy[3] = 4;
        for (int i = 4; i <= 1000000; i++) dy[i] = (dy[i - 3] + dy[i - 2] + dy[i - 1]) % MOD;
    }
}
