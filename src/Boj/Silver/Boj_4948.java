package Boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_4948 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int m, n;
    public static void main(String[] args) throws IOException {
        while(true){
            m = Integer.parseInt(br.readLine());
            if (m == 0) {
                break;
            }
            n = m * 2;
            solution();
        }
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
        int answer = 0;
        for (int i = m + 1; i <= n; i++) {
            if (!checker[i]) answer++;
        }
        System.out.println(answer);
    }
}
