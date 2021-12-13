package Boj.Bronze;

import java.util.Scanner;

public class Boj_2577 {
    // 숫자가 나온 횟수를 기록하기 위한 배열
    static int[] useNum = new int[10];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        solution(a, b, c);
    }

    public static void solution(int a, int b, int c) {
        int square = a * b * c;
        String str = String.valueOf(square);
        for (int i = 0; i < 10; i++) {
            for (char x : str.toCharArray()) {
                // char는 아스키 코드로 나오니 - 48로 비교
                if (x - 48 == i) {
                    useNum[i]++;
                }
            }
        }
        for (int x : useNum) {
            System.out.println(x);
        }
    }
}
