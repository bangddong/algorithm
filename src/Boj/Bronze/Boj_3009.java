package Boj.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_3009 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[][] arr = new int[3][3];
    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 2; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solution();
    }

    static void solution() {
        int x, y;
        if (arr[0][0] == arr[1][0]) {
            x = arr[2][0];
        } else {
            if (arr[0][0] == arr[2][0]) {
                x = arr[1][0];
            } else {
                x = arr[0][0];
            }
        }
        if (arr[0][1] == arr[1][1]) {
            y = arr[2][1];
        } else {
            if (arr[0][1] == arr[2][1]) {
                y = arr[1][1];
            } else {
                y = arr[0][1];
            }
        }
        System.out.println(x + " " + y);
    }
}
