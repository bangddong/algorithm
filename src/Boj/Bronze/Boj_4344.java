package Boj.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_4344 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    // 1. 각 학생의 점수를 더해 총점을 계산한다
    // 2. 입력된 N값을 나눠 평균을 구한다.
    // 3. 배열을 순회하며 평균보다 높은 학생 수를 구한다.
    // 4. 높은 학생 수 / N * 100을 소수 셋 째 자리까지 출력한다.
    static void solution(int[] score, double aver, int n) {
        double cnt = 0;
        for (int x : score) {
            if (x > aver) {
                cnt++;
            }
        }
        System.out.printf("%.3f", cnt / n * 100);
        System.out.println("%");
    }

    public static void main(String[] args) throws IOException {
        // 테스트 케이스 수
        int c = Integer.parseInt(br.readLine());

        for (int i = 0; i < c; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int n =Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            double sum = 0;
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
                sum += arr[j];
            }
            solution(arr, sum / n, n);
        }
    }
}
