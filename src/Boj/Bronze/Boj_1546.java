package Boj.Bronze;

import java.util.Scanner;

public class Boj_1546 {
    // 1. 각 점수배열 생성
    // 2. 배열 내 max 값 구하기
    // 3. 각 인덱스값 / max * 100
    // 4. 총 합 / n

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] score = new double[n];
        for (int i = 0; i < n; i++) {
            score[i] = sc.nextInt();
        }
        solution(score, n);
    }

    public static void solution(double[] arr, int n) {
        int max = Integer.MIN_VALUE;
        double sum = 0;
        // 2. 배열 내 max 값 구하기
        for (double x : arr) {
            max = (int) Math.max(max, x);
        }
        // 3. 각 점수 조작
        for (int i = 0; i < n; i++) {
            arr[i] = (arr[i] / max) * 100;
            sum += arr[i];
        }
        System.out.println(sum / n);

    }
}
