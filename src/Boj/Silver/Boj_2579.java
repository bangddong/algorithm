package Boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2579 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N;
    static int[] stairs;
    static int[][] dy;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        stairs = new int[N + 1];
        for (int i = 1; i <= N; i++) stairs[i] = Integer.parseInt(br.readLine());
        dy = new int[N + 1][2];
        solution();
    }

    // dy[n][0] = 이전 계단을 밟지 않았을 때
    // dy[n][1] = 연속해서 밟았을 때
    static void solution() {
        dy[1][1] = stairs[1];

        // 엣지 케이스로 계단이 하나 일 경우도 있다...
        if (N >= 2) {
            dy[2][0] = stairs[2];
            dy[2][1] = stairs[1] + stairs[2];
        }

        for (int i = 3; i <= N; i++) {
            // 이전 계단을 밟지 않았기에 i-2만 확인 대상이다.
            dy[i][0] = stairs[i] + Math.max(dy[i - 2][0], dy[i - 2][1]);
            // 연속해서 계단을 밟으려면 이전 계단은 연속해서 밟으면 안된다.
            dy[i][1] = stairs[i] + dy[i - 1][0];
        }

        System.out.println(Math.max(dy[N][0], dy[N][1]));
    }
}
