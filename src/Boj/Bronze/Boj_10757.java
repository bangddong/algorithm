package Boj.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_10757 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int T, k, n;
    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            k = Integer.parseInt(br.readLine());
            n = Integer.parseInt(br.readLine());
            solution();
        }
    }

    // 1. 0층부터 시작이며 0층의 i호에는 i만큼 사는걸로 시작.
    // 2. arr[i][y] = arr[i - 1][y] + arr[i][y - 1]
    static void solution() {
        int[][] arr = new int[15][15];
        for (int i = 0; i < arr.length; i++) {
            arr[i][1] = 1;
            arr[0][i] = i;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 2; j < arr.length; j++) {
                arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
            }
        }
        System.out.println(arr[k][n]);
    }
}
