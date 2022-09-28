package Boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1463 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int result = Integer.MAX_VALUE;
    static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        recursive(n, 0);

        System.out.println(result);
    }

    static void recursive(int n, int cnt) {
        if (n == 1) {
            result = Math.min(result, cnt);
            return;
        }

        if (cnt >= result) return;

        if (n % 3 == 0) recursive(n / 3, cnt + 1);
        if (n % 2 == 0) recursive(n / 2, cnt + 1);
        recursive(n - 1, cnt + 1);
    }

    static void dp() {
        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            // -1
            dp[i] = dp[i - 1] + 1;
            // /2
            if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            // /3
            if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1);
        }
        System.out.println(dp[n]);
    }
}
