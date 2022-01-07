package Boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2193 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N;
    static long[][] dy;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        dy = new long[N + 1][2];
        solution();
    }

    static void solution() {
        dy[1][1] = 1;
        // dy[i][0] = 0으로 끝나는 갯수
        // dy[i][1] = 1으로 끝나는 갯수
        for (int i = 2; i <= N; i++) {
            dy[i][0] = dy[i - 1][0] + dy[i - 1][1];
            dy[i][1] = dy[i - 1][0];
        }
        System.out.println(dy[N][0] + dy[N][1]);
    }
}
