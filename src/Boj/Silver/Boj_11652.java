package Boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_11652 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N;
    static long[] card;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        card = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            card[i] = Long.parseLong(br.readLine());
        }
        sort();
    }

    static void sort() {
        Arrays.sort(card, 1, N + 1);

        long mode = card[1];
        int minCnt = 1, numCnt = 1;

        for (int i = 2; i <= N; i++) {
            if (card[i] == card[i - 1]) {
                numCnt++;
            } else {
                numCnt = 1;
            }
            if (numCnt > minCnt) {
                mode = card[i];
                minCnt = numCnt;
            }
        }
        System.out.println(mode);
    }
}
