package Boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Boj_15970 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N;
    static ArrayList<Integer>[] a;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        a = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            a[i] = new ArrayList<>();
        }
        for (int i = 1; i <= N; i++) {
            int coord, color;
            st = new StringTokenizer(br.readLine());
            coord = Integer.parseInt(st.nextToken());
            color = Integer.parseInt(st.nextToken());
            a[color].add(coord);
        }
        pro();
    }

    // 내가 속한 index에서 바로 왼쪽에 있는 값
    static int toLeft(int color, int idx) {
        if (idx == 0) return Integer.MAX_VALUE;
        else return a[color].get(idx) - a[color].get(idx - 1);
    }
    // 내가 속한 index에서 바로 오른쪽에 있는 값
    static int toRight(int color, int idx) {
        if (idx == a[color].size() - 1) return Integer.MAX_VALUE;
        else return a[color].get(idx + 1) - a[color].get(idx);
    }

    static void pro() {
        for (int i = 1; i <= N; i++) {
            Collections.sort(a[i]);
        }
        int ans = 0;
        for (int color = 1; color <= N; color++) {
            for (int i = 0; i < a[color].size(); i++) {
                ans += Math.min(toLeft(color, i), toRight(color, i));
            }
        }

        System.out.println(ans);
    }
}
