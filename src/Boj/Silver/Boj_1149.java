package Boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1149 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N;
    static int[][] dy, RGB;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        dy = new int[N + 1][3];
        RGB = new int[N + 1][3];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                RGB[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solution();
    }

    static void solution() {
        dy[1][0] = RGB[1][0];
        dy[1][1] = RGB[1][1];
        dy[1][2] = RGB[1][2];

        for (int i = 2; i <= N; i++) {
            dy[i][0] = Math.min(dy[i - 1][1], dy[i - 1][2]) + RGB[i][0];
            dy[i][1] = Math.min(dy[i - 1][0], dy[i - 1][2]) + RGB[i][1];
            dy[i][2] = Math.min(dy[i - 1][0], dy[i - 1][1]) + RGB[i][2];
        }
        System.out.println(Math.min(Math.min(dy[N][0], dy[N][1]), dy[N][2]));
    }
}
