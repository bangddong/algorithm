package Boj.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1193 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int x;

    public static void main(String[] args) throws IOException {
        x = Integer.parseInt(br.readLine());
        findFrac();
    }

    static void findFrac() {
        int crossCnt = 1, sum = 0, px = 0, py = 0;
        while(true) {
            // x번째 원소 도달
            if (x <= crossCnt + sum) {
                // 홀수 판별
                if (crossCnt % 2 == 1) {
                    px = crossCnt - (x - sum - 1); // 분자
                    py = x - sum; // 분모
                    // 짝수 판별
                } else {
                    px = x - sum;
                    py = crossCnt - (x - sum - 1);
                }
                break;
            } else {
                // 원소 갯수 누적
                sum += crossCnt;
                // 대각선 수 증가
                crossCnt++;
            }
        }
        System.out.println(px + "/" + py);
    }
}
