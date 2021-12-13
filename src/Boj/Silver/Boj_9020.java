package Boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_9020 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int T;
    static int[] arr;
    static boolean[] primeArr;
    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        arr = new int[T];
        for (int i = 0; i < T; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        solution();
    }

    // 1. 4 이상 10000 이하의 수가 주어짐
    // 2. 두 소수의 합을 이용하여 푸는 문제이니 소수 배열을 갖고 있어야 함.
    static void solution() {
        setPrime();
        for (int x : arr) {
            printGoldbach(x);
        }
    }
    // 소수 배열 생성
    static void setPrime() {
        primeArr = new boolean[10001];
        for (int i = 2; i <= Math.sqrt(10001); i++) {
            if (primeArr[i]) {
                continue;
            }
            for (int j = i * i; j < primeArr.length; j += i) {
                primeArr[j] = true;
            }
        }
    }
    // 골드바흐 파티션 출력
    static void printGoldbach(int num) {
        int a, b;
        a = b = num / 2;
        while(true) {
            if (!primeArr[a] && !primeArr[b]) {
                System.out.println(a + " " + b);
                break;
            } else {
                a--;
                b++;
            }
        }
    }
}
