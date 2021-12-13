package Boj.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1011 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int T, x, y;
    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String str = br.readLine();
            st = new StringTokenizer(str, " ");
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            solution();
        }
    }
    // 1. 최대 이동 가능한 거리는 루트 거리 (소수점 제외)
    static void solution() {
        int dis = y - x; // 이동해야할 거리
        int answer = 0;
        int maxT = (int)Math.sqrt(dis);

        if (maxT == Math.sqrt(dis)) {
            answer = maxT * 2 - 1;
        } else if (dis <= maxT * maxT + maxT) {
            answer = maxT * 2;
        } else {
            answer = maxT * 2 + 1;
        }
        System.out.println(answer);
    }
}
