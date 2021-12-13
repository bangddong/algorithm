package Boj.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2869 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int a, b, v;
    public static void main(String[] args) throws IOException {
        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        solution();
    }

    // 1. 하루에 A만큼 올라갈 수 있지만 목표에 도달하지 못했다면 B만큼 떨어진다.
    // 2. 목표에 도착시에는 떨어지지 않으니 도착의 경우는 미리 제한다.
    // 3. 시간제한이 0.15로 반복문은 사용할 수 없다.
    static void solution() {
        int days = (v - b) / (a - b);
        if ((v - b) % (a - b) != 0) {
            days++;
        }
        System.out.println(days);
    }
}
