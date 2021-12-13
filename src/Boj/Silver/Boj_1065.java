package Boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1065 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    // 각 자리수를 분리하여 한수인지 확인
    static boolean calculator(int n) {
        if (n < 100) {
            return true;
        }
        boolean isHasSu = false;
        int a = n % 10; // 1의 자리
        int b = (n / 10) % 10; // 10의 자리
        int c = n / 100; // 100의 자리
        if (a - b == b - c) isHasSu = true;
        return isHasSu;
    }

    // 1부터 n까지 한수인지 체크
    static void solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (calculator(i)) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        solution(n);
    }
}
