package Boj.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2231 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, answer = 0;
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        solution();
    }

    // 1. N에 대한 가장 작은 생성자를 구하여라.
    // 2. N의 분해합은 분해합의 생성자이다. (245의 분해합 = 256, 256의 생성자 = 245)
    // 3. 10부터 N까지 돌며 분해합을 구하고 분해합이 N과 같다면 해당 I를 출력한다.
    static void solution() {
        for (int i = 0; i < n; i++) {
            if (getSum(i)) {
                answer = i;
                break;
            }
        }
        System.out.println(answer);
    }
    // 파라미터의 숫자를 분해하여 분해합을 확인한다.
    static boolean getSum(int num) {
        int sum = 0, tmp = num;
        while(tmp != 0) {
            sum += tmp % 10;
            tmp /= 10;
        }
        return sum + num == n;
    }
}
