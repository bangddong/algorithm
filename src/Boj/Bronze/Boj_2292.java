package Boj.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2292 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n = 0, answer = 1;

    // 1. 레이어가 증가할 때 마다 벌집의 갯수는 6개씩 늘어난다.
    // 2. 현재까지의 갯수 + 레이어 * 6이 현재 최대 벌집 수.
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        countRoom();
    }

    static void countRoom() {
        if (n == 1) {
            System.out.println(answer);
            return;
        }
        int sum = 2;
        while(sum <= n) {
            sum += 6 * answer;
            answer++;
        }
        System.out.println(answer);
    }
}
