package Boj.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_4153 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int a, b, c;
    public static void main(String[] args) throws IOException {
        while(true) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            if (a == 0) {
                break;
            }
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            solution();
        }
    }
    // 피타고라스 = 가로 제곱 + 세로 제곱 = 대각선 제곱
    static void solution() {
        if((a * a + b * b) == c * c) {
            System.out.println("right");
        }
        else if((b * b + c * c) == a * a) {
            System.out.println("right");
        }
        else if((c * c + a * a) == b * b) {
            System.out.println("right");
        }
        else {
            System.out.println("wrong");
        }
    }
}
