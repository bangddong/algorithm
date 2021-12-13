package Boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_4673 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    // 인자에 각 자리의 수를 합해 리턴한다.
    static int d(int n) {
        int sum = n;

        while (n > 0) {
            sum = sum + (n % 10);
            n = n / 10;
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        boolean[] check = new boolean[10001];

        for (int i = 1; i < 10001; i++) {
            int n = d(i);

            if (n < 10001) {
                check[n] = true;
            }
        }
        for (int i = 1; i < 10001; i++) {
            if (!check[i]) {
                System.out.println(i);
            }
        }
    }
}
