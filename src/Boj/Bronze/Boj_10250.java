package Boj.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_10250 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int T, H, W, N;
    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String str = br.readLine();
            st = new StringTokenizer(str, " ");
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            solution();
        }
    }
    // 1. 각 층의 1번째 객실을 우선적으로 채워야 한다.
    // 2. 객실의 번호는 YYXX호로 구성되어 있다.
    // 3. 호텔 층 수가 손님의 순서보다 크다면 N01호로 배정하면 된다.
    // 4. 그게 아니라면 N / H 의 나머지가 층수, N / H의 몫에 1을 더한값이 호수가 된다.
    static void solution() {
        if (N % H == 0) {
            System.out.println((H * 100) + (N / H));
        } else {
            System.out.println(((N % H) * 100) + ((N / H) + 1));
        }
    }
}
