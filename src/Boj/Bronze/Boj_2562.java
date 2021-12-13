package Boj.Bronze;

import java.util.Scanner;

public class Boj_2562 {
    // 최대값 저장 변수
    static int max = Integer.MIN_VALUE;
    // 최대값 인덱스 저장 변수
    static int maxIdx = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[9];
        for (int i = 0; i < 9; i++) {
            arr[i] = sc.nextInt();
        }
        solution(arr);
    }

    public static void solution(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // 배열의 i번째 값이 max값보다 크다면
            if (arr[i] > max) {
                // max 값 변경 및 인덱스 저장
                max = arr[i];
                maxIdx = i;
            }
        }
        System.out.println(max);
        System.out.println(maxIdx + 1);
    }
}
