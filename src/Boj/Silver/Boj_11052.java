package Boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_11052 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N;
    static int[] cards, dy;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        cards = new int[N + 1];
        dy = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) cards[i] = Integer.parseInt(st.nextToken());

        solution();
    }

    static void solution() {
        dy[1] = cards[1];
        for (int i = 2; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                dy[i] = Math.max(dy[i], dy[i - j] + cards[j]);
            }
        }
        System.out.println(dy[N]);
    }
}
