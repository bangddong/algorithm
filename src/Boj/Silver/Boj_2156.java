package Boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2156 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N;
    static int[] wines;
    static int[][] dy;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        wines = new int[N + 1];
        for (int i = 1; i <= N; i++) wines[i] = Integer.parseInt(br.readLine());
        dy = new int[N + 1][2];
        solution();
    }

    //dy[N][0] = 이전 잔을 마심
    //dy[N][1] = 이전 잔을 마시지 않음
    static void solution() {
        dy[1][0] = wines[1];

        if (N >= 2) {
            dy[2][0] = wines[1] + wines[2];
            dy[2][1] = wines[2];
        }

        for (int i = 3; i <= N; i++) {
            dy[i][0] = wines[i] + dy[i - 1][1];
            dy[i][1] = wines[i] + Math.max(dy[i - 2][0], dy[i - 2][1]);
            // 두 잔을 건너뛸 수도 있다.
            dy[i][1] = Math.max(dy[i][1], Math.max(dy[i - 3][0], dy[i - 3][1]) + wines[i]);
        }
        System.out.println(Math.max(Math.max(dy[N][0], dy[N][1]), Math.max(dy[N - 1][0], dy[N - 1][1])));
    }
}
