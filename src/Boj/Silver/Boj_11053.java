package Boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_11053 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int A = Integer.parseInt(br.readLine());
        int[] arr = new int[A + 1];
        int[] dp = new int[A + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= A; i++) arr[i] = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= A; i++) {
            int tmp = 0;
            for (int j = 1; j < i; j++) {
                if (arr[i] > arr[j]) {
                    tmp = Math.max(tmp, dp[j]);
                }
            }
            dp[i] = tmp + 1;
        }
        int answer = 0;
        for (int i : dp) {
            answer = Math.max(i, answer);
        }
        System.out.println(answer);
    }
}
