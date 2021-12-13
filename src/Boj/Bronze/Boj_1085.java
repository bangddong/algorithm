package Boj.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1085 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int x, y, w, h;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        solution();
    }

    // 1. w나 h까지의 거리와 0까지의 거리중 가까운 값이 최소거리
    static void solution() {
        int a, b;
        a = Math.min(w - x, h - y);
        b = Math.min(x, y);
        System.out.println(Math.min(a, b));
    }
}
