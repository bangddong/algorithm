package Boj.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_3053 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static double R;
    public static void main(String[] args) throws IOException {
        R = Integer.parseInt(br.readLine());
        solution();
    }

    // 1. 유클리드 기하학에서의 원이 넓이 = 파이 * 반지름 제곱
    // 2. 택시 기하학에서의 원의 넓이 = 2 * 반지릅 제곱
    static void solution() {
        System.out.println(Math.PI * R * R);
        System.out.println(2 * R * R);
    }
}
