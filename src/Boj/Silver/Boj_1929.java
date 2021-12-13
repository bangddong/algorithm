package Boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1929 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int m, n;
    public static void main(String[] args) throws IOException {
        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        solution();
    }
    // 1. 0과 1은 소수가 아님.
    // 2. 자기 자신 외에 나누어지면 안되니 i의 배수는 모두 소수가 아님.
    static void solution() {
        boolean[] checker = new boolean[n + 1];
        checker[0] = checker[1] = true;

        for (int i = 2; i <= Math.sqrt(n + 1); i++) {
            if (checker[i]) {
                continue;
            }
            for (int j = i * i; j < n + 1; j += i) {
                checker[j] = true;
            }
        }
        for (int i = m; i <= n; i++) {
            if (!checker[i]) System.out.println(i);
        }
    }
}
